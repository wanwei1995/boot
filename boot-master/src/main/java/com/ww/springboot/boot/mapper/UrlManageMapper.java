package com.ww.springboot.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ww.springboot.boot.model.UrlManage;

@Mapper
public interface UrlManageMapper {
	
	
	@Select("select id,p_id pId,name,url from md_url")
	public List<UrlManage> findAll();
	
	@Select("select id,p_id pId,name,url from md_url where id = #{id}")
	public UrlManage findByPId(String id);

	@Insert("<script>"
			+ "insert into md_url (id,p_id,name"
			+ "<if test=\"url != null and url != '' \"> ,url</if>" 
			+ ") values(#{id},#{pId},"
			+ "#{name}"
			+ "<if test=\"url != null and url != '' \"> ,#{url}</if>" 
			+ ")"
			+ "</script>")
	public void insert(UrlManage urlManage);

	@Select("Select count(*) from md_url where p_id = #{pId}")
	public int selectByPId(Long pId);

}
