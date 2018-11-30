package com.ww.springboot.boot.service;

import java.util.List;

import com.ww.springboot.boot.model.UrlManage;

public interface UrlManageService {
	
	
	List<UrlManage> findAll();

	UrlManage findByPId(String id);

	void insert(UrlManage urlManage);

	int selectByPId(Long pId);

}
