package com.ww.springboot.boot.mq;

/**
 * @author wanwei
 * @TODO   重试机制的实现 ：消息处理失败后将信息发送到另一个队列上，
 *         此队列设置过期时间已经过期后转向的交换机和routing_key与原交换机和队列一致；
 *         等到过期时间一到，就将消息重新发送到原来的队列并进行消费
 *         ：可以添加下一次执行时间已经重试次数
 * @date: 2018年9月20日 下午2:25:35 
 */
public class QueueConstants {

    public static final String QUEUE_RETRY = "retry";

    //过期后指定交换机
    public static final String DEAD_LETTER_EX = "x-dead-letter-exchange";
    //过期后指定队列
    public static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    public static final String DEAD_LETTER_TIMEOUT = "x-message-ttl";

    /**
     * 测试1
     */
    public static final String MQ_TEST1 = "mq.test";

    /**
     * 队列名称枚举
     */
    public enum QueueEnum {
       
        /**
         * 百世汇通一键揽收分发信息枚举/队列
         */
        TMS_ONE_KEY_COLLECT_DISPATCH(QueueConstants.MQ_TEST1,
            ExchangeEnum.MQ_EXCHANGE_TEST1);

        QueueEnum(String queueName, ExchangeEnum exchangeEnum) {
            this.queueName = queueName;
            this.routingKey = queueName;
            this.exchangeEnum = exchangeEnum;
        }

        QueueEnum(String queueName, String routingKey, ExchangeEnum exchangeEnum) {
            this.queueName = queueName;
            this.routingKey = routingKey;
            this.exchangeEnum = exchangeEnum;
        }

        public static QueueEnum getQueueEnumByName(String queueName) {
            QueueConstants.QueueEnum[] queueEnums = QueueConstants.QueueEnum.values();
            for (QueueConstants.QueueEnum queueEnum : queueEnums) {
                if (queueEnum.getQueueName().equals(queueName)) {
                    return queueEnum;
                }
            }
            return null;
        }

        private String queueName;

        private String routingKey;

        private ExchangeEnum exchangeEnum;

        public final String getQueueName() {
            return queueName;
        }

        public String getRoutingKey() {
            return routingKey;
        }

        public ExchangeEnum getExchangeEnum() {
            return exchangeEnum;
        }
    }
}
