package com.ww.springboot.boot.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ww.springboot.boot.aspect.WanweiInterceptor;
import com.ww.springboot.boot.mapper.StudyPlanServiceMapper;
import com.ww.springboot.boot.model.StudyPlan;
import com.ww.springboot.boot.service.StudyPlanService;

@Service
public class StudyPlanServiceImpl implements StudyPlanService{

    @Autowired	
	private StudyPlanServiceMapper mapper;
	@Override
	public List<StudyPlan> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}
	@Override
	public void update(StudyPlan studyPlan) {
		// TODO Auto-generated method stub
		//超过一百更新为100
		StudyPlan studyPlanOld = selectByName(studyPlan.getStudyName());
		studyPlan.setSchedule(studyPlanOld.getSchedule()+studyPlan.getSchedule());
		if(studyPlan.getSchedule()>100){
			studyPlan.setSchedule(100);
		}
		studyPlan.setOperatingTime(new Date());
		mapper.update(studyPlan);
	}
	@Override
	public StudyPlan selectByName(String studyName) {
		// TODO Auto-generated method stub
		return mapper.selectByName(studyName);
	}
	@Override
	public void insert(StudyPlan studyPlan) {
		mapper.insert(studyPlan);
		
	}
	@Override
	public List<StudyPlan> findBySelective(String way, String sort) {
		// TODO Auto-generated method stub
		return mapper.findBySelective(way,sort);
	}

}
