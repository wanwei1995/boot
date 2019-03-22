package com.ww.springboot.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.ww.springboot.boot.model.StudyPlan;
import com.ww.springboot.boot.sql.StudyPlanSqlProvider;

@Mapper
public interface StudyPlanServiceMapper {
	
	
    @Select("select study_name studyName,schedule from life_study_plan")
	List<StudyPlan> findAll();

    @Update("update life_study_plan set schedule = #{schedule},operating_time = #{operatingTime} where study_name = #{studyName}")
	void update(StudyPlan studyPlan);

    @Select("select study_name studyName,schedule from life_study_plan where study_name = #{studyName}")
	StudyPlan selectByName(String studyName);

    @Insert(" insert into life_study_plan (study_name) values(#{studyName})")
	void insert(StudyPlan studyPlan);

    @SelectProvider(type = StudyPlanSqlProvider.class, method = "findBySelective")
	List<StudyPlan> findBySelective(String way, String sort);
    
    @Select("select study_name studyName,schedule from life_study_plan where study_name like CONCAT('%',#{studyName},'%')")
    List<StudyPlan> selectByLikeName(String studyName);
}
