package com.ww.springboot.boot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.ww.springboot.boot.model.Md5;

@Mapper
public interface Md5Mapper {
	
	
	@Insert("Insert into b_md5 (cipher_text,text,info)"
			+ "values"
			+ "(#{cipherText},#{text},#{info})")
	void insert(Md5 md5);

}
