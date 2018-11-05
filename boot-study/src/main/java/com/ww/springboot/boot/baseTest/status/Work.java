package com.ww.springboot.boot.baseTest.status;

import com.ww.springboot.boot.baseTest.status.son.StatusA;

/**
 * @author wanwei
 * @TODO  工作   :不同时间工作状态不一样
 * @date: 2018年10月9日 上午10:10:41 
 */
public class Work {
	
	private Integer hour;
	
	private Status status;
	
	private Boolean finish = false;
	
	public Work(){
		status = new StatusA();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Boolean getFinish() {
		return finish;
	}

	public void setFinish(Boolean finish) {
		this.finish = finish;
	}
	
	public void workStatus(){
		status.workStatus(this);
	}

	
}
