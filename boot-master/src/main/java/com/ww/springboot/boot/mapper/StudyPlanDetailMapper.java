package com.ww.springboot.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ww.springboot.boot.model.StudyPlanDetail;

@Mapper
public interface StudyPlanDetailMapper {
	
	
	@Select("select study_name studyName ,study_detail studyDetail,create_time createTime from life_study_plan_detail "
			+ "where study_name = #{studyName} order by create_time DESC")
	List<StudyPlanDetail> selectByStudyName(String studyName);

	@Insert("insert into life_study_plan_detail (study_name,study_detail,create_time)"
			+ "values (#{studyName},#{studyDetail},#{createTime})")
	void insert(StudyPlanDetail studyPlanDetail);

}
