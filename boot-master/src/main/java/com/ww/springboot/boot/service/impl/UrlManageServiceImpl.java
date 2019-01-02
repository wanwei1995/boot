package com.ww.springboot.boot.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.ww.springboot.boot.mapper.UrlManageMapper;
import com.ww.springboot.boot.model.UrlManage;
import com.ww.springboot.boot.service.UrlManageService;

@Service
public class UrlManageServiceImpl implements UrlManageService{
	
	@Autowired
	private UrlManageMapper urlManageMapper;
	
	@Autowired
	private HazelcastInstance instance;

	@Override
	public List<UrlManage> findAll() {
		//
		Map<String, List<UrlManage>> urlMap = instance.getMap("urlMap");
		if(urlMap.get("url") == null){
			List<UrlManage> urlManagesList = urlManageMapper.findAll();
			urlMap.put("url", urlManagesList);
		}
		return urlMap.get("url");
	}

	@Override
	public UrlManage findById(Long id) {
		// TODO Auto-generated method stub
		return urlManageMapper.findById(id);
	}

	@Override
	public void insert(UrlManage urlManage) {
		Map<String, List<UrlManage>> urlMap = instance.getMap("urlMap");
		if(urlMap.get("url") != null){
			urlMap.remove("url");
		}
		urlManage.setCreateTime(new Date());
		urlManageMapper.insert(urlManage);
		
	}

	@Override
	public int selectNumByPId(Long pId) {
		// TODO Auto-generated method stub
		return urlManageMapper.selectNumByPId(pId);
	}

	@Override
	public void updateClickTimes(Long id) {
		urlManageMapper.updateClickTimes(id);
		
	}

	@Override
	public void update(UrlManage urlManage) {
		Map<String, List<UrlManage>> urlMap = instance.getMap("urlMap");
		if(urlMap.get("url") != null){
			urlMap.remove("url");
		}
		urlManageMapper.update(urlManage);
	}

	@Override
	public List<UrlManage> findUsualUrl() {
		List<UrlManage> urlManages = urlManageMapper.findUsualUrl();
		for(UrlManage urlManage :urlManages){
			urlManage.setName(urlManage.getpName()+"--"+urlManage.getName());
		}
		return urlManages;
	}
}
