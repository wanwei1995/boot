package com.ww.springboot.boot.service;

import java.util.List;

import com.ww.springboot.boot.model.UrlManage;

public interface UrlManageService {
	
	
	List<UrlManage> findAll();

	UrlManage findById(Long id);

	void insert(UrlManage urlManage);

	int selectNumByPId(Long pId);

	void updateClickTimes(Long id);
	
	void updateOperateTime(Long id);

	void update(UrlManage urlManage);

	List<UrlManage> findUsualUrl();
	
	List<UrlManage> findUsualUrlByOperateTime();

	void clearCache();

	void delete(Long id);

	int selectById(Long id);

	Long selectIdByPId(Long pId);
}
