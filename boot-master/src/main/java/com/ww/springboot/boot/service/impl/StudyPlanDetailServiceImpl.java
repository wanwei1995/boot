package com.ww.springboot.boot.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ww.springboot.boot.mapper.StudyPlanDetailMapper;
import com.ww.springboot.boot.model.StudyPlanDetail;
import com.ww.springboot.boot.service.StudyPlanDetailService;

@Service
public class StudyPlanDetailServiceImpl implements StudyPlanDetailService{

	@Autowired
	private StudyPlanDetailMapper mapper;
	
	
	@Override
	public List<StudyPlanDetail> selectByStudyName(String studyName) {
		// TODO Auto-generated method stub
		return mapper.selectByStudyName(studyName);
	}


	@Transactional
	public void insert(StudyPlanDetail studyPlanDetail) {
		studyPlanDetail.setCreateTime(new Date());
		mapper.insert(studyPlanDetail);
	}

}
