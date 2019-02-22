package com.ww.springboot.boot.service;

import java.util.List;

import com.ww.springboot.boot.model.StudyPlanDetail;

public interface StudyPlanDetailService {
	
	List<StudyPlanDetail> selectByStudyName(String studyName);

	void insert(StudyPlanDetail studyPlanDetail);

}
