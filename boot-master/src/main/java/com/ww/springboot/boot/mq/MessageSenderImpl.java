package com.ww.springboot.boot.mq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.ww.springboot.boot.model.ExpServiceMsg;
import com.ww.springboot.boot.mq.QueueConstants.QueueEnum;


@Service
public class MessageSenderImpl implements MessageSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private AmqpAdmin amqpAdmin;
	
	private final Double DEFAULT_TIMEOUT = 60000D;

	@Override
	public void send(QueueEnum QueueEnum, ExpServiceMsg expServiceMsg) {
		//有事务的话,事务处理完后再发送MQ
		TransactionSynchronizationManager
        .registerSynchronization(new TransactionSynchronizationAdapter() {
                                     @Override
                                     public void afterCommit() {
                                         rabbitTemplate.convertAndSend(QueueEnum.getExchangeEnum().getExchangeName(), QueueEnum.getRoutingKey(), expServiceMsg);
                                     }
                                 }
        );
		
	}

	@Override
	public void sendRetry(QueueEnum QueueEnum, ExpServiceMsg expServiceMsg) {
	 //失败后进来新建异常一个处理队列和交换机
		String orgRoutingKey = QueueEnum.getRoutingKey();
		String orgExchangeName = QueueEnum.getExchangeEnum().getExchangeName();
		String waitingQueueName = QueueEnum.getRoutingKey() + "retry";
		Double expiration = DEFAULT_TIMEOUT * Math.pow(2, Double.valueOf(1));
		
		Queue retryQueue = QueueBuilder.nonDurable(waitingQueueName)
                .withArgument(QueueConstants.DEAD_LETTER_EX,
                    orgExchangeName) // DLX，dead letter发送到的exchange
                .withArgument(QueueConstants.DEAD_LETTER_ROUTING_KEY, orgRoutingKey)
                .withArgument(QueueConstants.DEAD_LETTER_TIMEOUT,
                    expiration.intValue()) // 设置队列的过期时间
                .autoDelete()
                .build();
		amqpAdmin.declareQueue(retryQueue);
        Exchange exchange = ExchangeBuilder.directExchange(orgExchangeName)
            .durable(true)
            .build();
        amqpAdmin.declareExchange(exchange);
        amqpAdmin.declareBinding(
            BindingBuilder.bind(retryQueue).to(exchange).with(waitingQueueName).noargs());
        rabbitTemplate
            .convertAndSend(orgExchangeName, waitingQueueName, expServiceMsg);
	}

}
