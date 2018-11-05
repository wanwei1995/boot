package com.ww.springboot.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ww.springboot.boot.model.PersonManage;

@Mapper
public interface PersonManageMapper {
	
    @Select("<script>"
    		+ "select id ,person_name personName,status,type,department,job_name jobName,"
    		+ " sex,age,school,education,profession,school_attribute schoolAttribute,experience"
    		+ " phone,email,"
    		+ " create_by createBy,create_time createTime,"
    		+ " update_by updateBy,update_time updateTime"
    		+ " from doc_person_manage "
    		+ "<where>"
    		+ "is_deleted = 0"
    		+ "<if test=\"personName != null and personName != '' \"> and  person_name like CONCAT('%', #{personName}, '%')</if>"
    		+ "<if test=\"status != null\"> and  status = #{status}</if>" 
    		+ "</where>"
    		+ "</script>")
	List<PersonManage> findList(PersonManage personManage);

    @Insert("insert into doc_person_manage (person_name,status,type,department,"
    		+ " job_name,sex,age,school,education,profession,school_attribute,experience,"
    		+ "phone,email,create_time,create_by)"
			+ "values"
			+ "(#{personName},#{status},#{type},#{department},#{jobName},#{sex}"
			+ ",#{age},#{school},#{education},#{profession}"
			+ ",#{schoolAttribute},#{experience},#{phone},#{email},#{createTime},#{createBy})")
	void save(PersonManage personManage);

    @Update("<script>" + " UPDATE doc_person_manage " + " SET is_deleted = 1 " + " WHERE id in"
            + " <foreach collection=\"idArray\" item=\"item\" index=\"index\" open=\"(\" separator=\",\" close=\")\">#{item}</foreach> "
            + " </script>")
	void deleteList(@Param("idArray") String[] idArray);

    @Update("update doc_person_manage "
			+ "set "
			+ " person_name = #{personName},"
			+ " status = #{status},"
			+ " type = #{type},"
			+ " department = #{department},"
			+ " job_name = #{jobName},"
			+ " sex = #{sex},"
			+ " age = #{age},"
			+ " school = #{school},"
			+ " education = #{education},"
			+ " profession = #{profession},"
			+ " schoolAttribute = #{schoolAttribute},"
			+ " experience = #{experience},"
			+ " phone = #{phone},"
			+ " email = #{email},"
			+ " update_by = #{updateBy},"
			+ " update_time = #{updateTime},"
			+ " where id = #{id} and is_deleted = 0")
	void update(PersonManage personManage);

    @Select("select id ,person_name personName,status,type,department,job_name jobName," + 
    		" sex,age,school,education,profession,school_attribute schoolAttribute,experience," + 
    		" phone,email"
    		+ ",create_by createBy,create_time createTime,"
    		+ " update_by updateBy,update_time updateTime"
    		+ " from doc_person_manage "
    		+ "where id = #{id} and "
    		+ "is_deleted = 0"
    		)
	PersonManage findById(Long id);

}
