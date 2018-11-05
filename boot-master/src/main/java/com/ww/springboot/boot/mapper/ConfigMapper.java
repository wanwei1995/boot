package com.ww.springboot.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ww.springboot.boot.model.Configuration;

@Mapper
public interface ConfigMapper {
	
	
	@Select("<script>"
			+ "select id ,config_no configNo ,descr_c descrC,value,create_time createTime,"
			+ "create_by createBy,update_time updateTime,update_by updateBy"
			+ " from cfg_configuration "
			+ "<where>"
			+ " is_deleted = 0"
			+ "<if test=\"configNo != null and configNo != '' \"> and  config_no like CONCAT('%', #{configNo}, '%')</if>" 
			+ "<if test=\"descrC != null and descrC != '' \"> and  descr_c like CONCAT('%', #{descrC}, '%')</if>" 
			+ "<if test=\"value != null and value != '' \"> and  value like CONCAT('%', #{value}, '%')</if>" 
			+ "</where>"
			+ "</script>")
	List<Configuration> findList(Configuration configuration);

	@Insert("insert into cfg_configuration (config_no,value,descr_c,create_time,create_by)"
			+ "values"
			+ "(#{configNo},#{value},#{descrC},#{createTime},#{createBy})")
	void save(Configuration configuration);

	@Select("select value"
			+ " from cfg_configuration "
			+ "where"
			+ " is_deleted = 0 and config_no = #{configNo}")
	String findValueByNo(String configNo);

	@Update("<script>" + " UPDATE cfg_configuration " + " SET is_deleted = 1 " + " WHERE id in"
            + " <foreach collection=\"idArray\" item=\"item\" index=\"index\" open=\"(\" separator=\",\" close=\")\">#{item}</foreach> "
            + " </script>")
    public void deleteList(@Param("idArray") String[] idArray);

	@Select("select id ,config_no configNo ,descr_c descrC,value,create_time createTime,"
			+ "create_by createBy,update_time updateTime,update_by updateBy,version"
			+ " from cfg_configuration "
			+ "where"
			+ " is_deleted = 0 and id = #{id}")
	Configuration findById(Long id);
	
	@Select("select id ,config_no configNo ,descr_c descrC,value,create_time createTime,"
			+ "create_by createBy,update_time updateTime,update_by updateBy,version"
			+ " from cfg_configuration "
			+ "where"
			+ " is_deleted = 0 and id = #{id}")
	Configuration findById2(Long id);
  
	@Update("<script>"
			+"update cfg_configuration "
			+ "set "
			+ " config_no = #{configNo},"
			+ " value = #{value},"
			+ "descr_c = #{descrC}"
			+ "<if test=\"version != 0 \"> ,version = version+1 </if>" 
			+ " where id = #{id} and is_deleted = 0"
			+ "</script>")
	void update(Configuration configuration);

}
