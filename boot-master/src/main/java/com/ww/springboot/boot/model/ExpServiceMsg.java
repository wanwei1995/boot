package com.ww.springboot.boot.model;

import java.util.Date;

/**
 * @author wanwei
 * @TODO MQ消息管理类
 * @date: 2018年9月17日 下午5:29:20 
 */
public class ExpServiceMsg extends BaseEntity{
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//消息id
    private  String id;
   
	 //业务跟踪单号
    private  String businessCode;
   
	 //业务id
    private  long businessId;
   
	 //交换机
    private  String exName;
   
	 //路由key
    private  String routingKey;
   
	 //状态：10 发送中 20发送成功 30发送失败 40 处理中 50 处理成功 60 处理失败
    private  int status;
   
	 //错误信息
    private  String errorMsg;
   
	 //执行次数
    private  int msgCount;
   
	 //消息能够重试次数
    private  int retryCount;
   
	 //下次执行时间
    private  Date nextInvokeTime;
    
    private String message;
   
	 //0
    private  int isDeleted;
    
    

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getBusinessCode() {
		return businessCode;
	}



	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}



	public long getBusinessId() {
		return businessId;
	}



	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}



	public String getExName() {
		return exName;
	}



	public void setExName(String exName) {
		this.exName = exName;
	}



	public String getRoutingKey() {
		return routingKey;
	}



	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public String getErrorMsg() {
		return errorMsg;
	}



	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}



	public int getMsgCount() {
		return msgCount;
	}



	public void setMsgCount(int msgCount) {
		this.msgCount = msgCount;
	}



	public int getRetryCount() {
		return retryCount;
	}



	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}



	public Date getNextInvokeTime() {
		return nextInvokeTime;
	}



	public void setNextInvokeTime(Date nextInvokeTime) {
		this.nextInvokeTime = nextInvokeTime;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public int getIsDeleted() {
		return isDeleted;
	}



	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}



	@Override
	public String toString() {
		return "ExpServiceMsg [id=" + id + ", businessCode=" + businessCode + ", businessId=" + businessId + ", exName="
				+ exName + ", routingKey=" + routingKey + ", status=" + status + ", errorMsg=" + errorMsg
				+ ", msgCount=" + msgCount + ", retryCount=" + retryCount + ", nextInvokeTime=" + nextInvokeTime
				+ ", message=" + message + ", isDeleted=" + isDeleted + "]";
	}
}
