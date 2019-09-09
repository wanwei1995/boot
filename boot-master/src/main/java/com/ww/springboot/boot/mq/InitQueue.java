/*
package com.ww.springboot.boot.mq;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * 初始化队列跟交换机，并绑定
 *//*

@Configuration
public class InitQueue{

    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    public void init() throws Exception {
        QueueConstants.QueueEnum[] queueEnums = QueueConstants.QueueEnum.values();
        for (QueueConstants.QueueEnum queueEnum : queueEnums) {
            Queue queue = QueueBuilder.durable(queueEnum.getQueueName())
                    .build();
            amqpAdmin.declareQueue(queue);
            Exchange exchange = ExchangeBuilder.directExchange(queueEnum.getExchangeEnum().getExchangeName())
                    .durable(true)
                    .build();
            amqpAdmin.declareExchange(exchange);
            amqpAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(queueEnum.getRoutingKey()).noargs());
        }
    }

    */
/**
     * 设置转换器
     *//*

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setDefaultRequeueRejected(false);
        factory.setConcurrentConsumers(1);
        factory.setMaxConcurrentConsumers(3);
        return factory;
    }
}
*/
