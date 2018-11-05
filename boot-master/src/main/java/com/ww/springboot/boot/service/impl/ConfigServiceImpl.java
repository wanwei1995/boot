package com.ww.springboot.boot.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ww.springboot.boot.jedis.JedisPoolService;
import com.ww.springboot.boot.mapper.ConfigMapper;
import com.ww.springboot.boot.model.Configuration;
import com.ww.springboot.boot.service.ConfigService;



@Service
public class ConfigServiceImpl implements ConfigService {
	
	@Autowired
	private ConfigMapper configMapper;
	
	@Autowired
	private JedisPoolService jedisPoolService;
	

	@Override
	public List<Configuration> findList(Configuration configuration) {
		
		return configMapper.findList(configuration);
	}


	@Transactional
	public void save(Configuration configuration) {
		configuration.setCreateTime(new Date());
		configuration.setCreateBy("admin");
		configMapper.save(configuration);
		jedisPoolService.set(configuration.getConfigNo(), configuration.getValue());
	}


	@Override
	public String getValueForKey(String configNo) {
		//先查缓存
		String value = jedisPoolService.get(configNo);
		if(!StringUtils.isEmpty(value)){
			return value;
		}
		//再查数据库
		value = findValueByNo(configNo);
		return value;
	}


	@Override
	public String findValueByNo(String configNo) {
		String value = configMapper.findValueByNo(configNo);
		if(!StringUtils.isEmpty(value)){
			jedisPoolService.set(configNo, value);
		}
		return value;
	}
	@Override
	public void deleteList(String ids) {
		String[] data = ids.split(",");
		configMapper.deleteList(data);
	}


	/**
	 * @author wanwei
	 * @TODO 清空缓存
	 * @date: 2018年9月13日 下午2:51:22 
	 */
	@Override
	public void clear() {
		jedisPoolService.clear();
	}


	@Override
	public Configuration findById(Long id) {
		// TODO Auto-generated method stub
		return configMapper.findById(id);
	}
	
	@Override
	public Configuration findById2(Long id) {
		// TODO Auto-generated method stub
		return configMapper.findById(id);
	}


	@Transactional
	public void update(Configuration configuration) {
		configuration.setUpdateBy("admin");
		configuration.setUpdateTime(new Date());
		jedisPoolService.set(configuration.getConfigNo(),configuration.getValue());
		configMapper.update(configuration);
	}
}
