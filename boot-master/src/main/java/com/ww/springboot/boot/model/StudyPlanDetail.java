package com.ww.springboot.boot.model;

import java.util.Date;

public class StudyPlanDetail {
	
	private Long id;
	
	private String studyName;
	
	private String studyDetail;
	
	private Date createTime;

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

	public String getStudyDetail() {
		return studyDetail;
	}

	public void setStudyDetail(String studyDetail) {
		this.studyDetail = studyDetail;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
