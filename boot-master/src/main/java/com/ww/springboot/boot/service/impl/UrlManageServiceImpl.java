package com.ww.springboot.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ww.springboot.boot.mapper.UrlManageMapper;
import com.ww.springboot.boot.model.UrlManage;
import com.ww.springboot.boot.service.UrlManageService;

@Service
public class UrlManageServiceImpl implements UrlManageService{
	
	@Autowired
	private UrlManageMapper urlManageMapper;

	@Override
	public List<UrlManage> findAll() {
		// TODO Auto-generated method stub
		return urlManageMapper.findAll();
	}

	@Override
	public UrlManage findByPId(String id) {
		// TODO Auto-generated method stub
		return urlManageMapper.findByPId(id);
	}

	@Override
	public void insert(UrlManage urlManage) {
		urlManageMapper.insert(urlManage);
		
	}

	@Override
	public int selectByPId(Long pId) {
		// TODO Auto-generated method stub
		return urlManageMapper.selectByPId(pId);
	}

}
