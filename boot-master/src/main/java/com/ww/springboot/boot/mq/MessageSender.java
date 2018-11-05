package com.ww.springboot.boot.mq;

import com.ww.springboot.boot.model.ExpServiceMsg;

public interface MessageSender {
	
	void send(QueueConstants.QueueEnum QueueEnum,ExpServiceMsg expServiceMsg);
	
	void sendRetry(QueueConstants.QueueEnum QueueEnum,ExpServiceMsg expServiceMsg);

}
