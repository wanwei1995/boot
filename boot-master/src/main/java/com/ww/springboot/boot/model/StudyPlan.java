package com.ww.springboot.boot.model;

import java.util.Date;

/**
 * @author wanwei
 * @TODO
 * @date: 2019年2月18日 下午3:35:35 
 */
public class StudyPlan {
	
	private  Long id;
	
	//计划名
	private String studyName;
	
	//进度
	private int schedule;
	
	private Date operatingTime;
	
	
	//
	public enum SortEnum {
		
		operatingTime("学习时间","0"),schedule("熟练度","1");
		
		SortEnum(String text,String value){
			this.text = text;
			this.value = value;
		}
		
		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		private String text;
		
		private String value;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public int getSchedule() {
		return schedule;
	}

	public void setSchedule(int schedule) {
		this.schedule = schedule;
	}

	public Date getOperatingTime() {
		return operatingTime;
	}

	public void setOperatingTime(Date operatingTime) {
		this.operatingTime = operatingTime;
	}
	
}
