package com.ww.springboot.boot.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ww.springboot.boot.model.UrlManage;

@Mapper
public interface UrlManageMapper {
	
	
	@Select("select id,p_id pId,name,url from md_url")
	public List<UrlManage> findAll();
	
	@Select("select id,p_id pId,name,url from md_url where id = #{id}")
	public UrlManage findById(Long id);

	@Insert("<script>"
			+ "insert into md_url (id,p_id,name,create_time,operate_time"
			+ "<if test=\"url != null and url != '' \"> ,url</if>" 
			+ ") values(#{id},#{pId},"
			+ "#{name},#{createTime},#{operateTime}"
			+ "<if test=\"url != null and url != '' \"> ,#{url}</if>" 
			+ ")"
			+ "</script>")
	public void insert(UrlManage urlManage);

	@Select("Select count(*) from md_url where p_id = #{pId}")
	public int selectNumByPId(Long pId);

	
	@Update(" update md_url set click_times = click_times +1,operate_time = #{operateTime} where id = #{id}")
	public void updateClickTimes(@Param("operateTime") Date operateTime,@Param("id") Long id);
	
	@Update(" update md_url set operate_time = #{operateTime} where id = #{id}")
	public void updateOperateTime(@Param("operateTime") Date operateTime,@Param("id") Long id);

	
	@Update(" update md_url set name = #{name},url = #{url} where id = #{id}")
	public void update(UrlManage urlManage);

	@Select("select md_url.id ,t2.name pName,md_url.name,url ,click_times clickTimes from md_url," + 
			"(select id,name from md_url) t2 where t2.id = md_url.p_id" + 
			" order by click_times desc limit 10")
	public List<UrlManage> findUsualUrl();
	
	@Select("select md_url.id ,t2.name pName,md_url.name,url ,click_times clickTimes from md_url," + 
			"(select id,name from md_url) t2 where t2.id = md_url.p_id" + 
			" order by operate_time desc limit 3")
	public List<UrlManage> findUsualUrlByOperateTime();

	@Delete("delete from md_url where id = #{id}")
	public void delete(Long id);

	@Select("select count(*) from md_url where id = #{id}")
	public int selectById(Long id);

	@Select("Select id from md_url where p_id = #{pId} ORDER BY id DESC LIMIT 1")
	public Long selectIdByPId(Long pId);
	
}
