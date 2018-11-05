package com.ww.springboot.boot.mq;

/**
 * @author zzh
 * 功能相同的队列使用同一个交换机
 * 交换机常量
 */
public enum ExchangeEnum {
    
    /**
     * 一键揽收分发信息交换机
     */
    MQ_EXCHANGE_TEST1("exchange.test1")

    ;

    ExchangeEnum(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    private String exchangeName;

    public String getExchangeName() {
        return exchangeName;
    }
}
