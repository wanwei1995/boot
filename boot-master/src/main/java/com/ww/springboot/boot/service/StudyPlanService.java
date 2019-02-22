package com.ww.springboot.boot.service;

import java.util.List;

import com.ww.springboot.boot.model.StudyPlan;

public interface StudyPlanService {

	
	List<StudyPlan> findAll();
	
	StudyPlan selectByName(String studyName);

	void update(StudyPlan studyPlan);

	void insert(StudyPlan studyPlan);

	List<StudyPlan> findBySelective(String way, String sort);
}
