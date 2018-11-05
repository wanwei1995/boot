package com.ww.springboot.boot.service;

import java.util.List;

import com.ww.springboot.boot.model.Configuration;

public interface ConfigService {

	 List<Configuration> findList(Configuration configuration);

	 void save(Configuration configuration);
	 
	 String getValueForKey(String configNo);
	 
	 String findValueByNo(String configNo);

	void deleteList(String ids);

	void clear();

	Configuration findById(Long id);
	
	Configuration findById2(Long id);

	void update(Configuration configuration);
	
}
