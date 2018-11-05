package com.ww.springboot.boot.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ww.springboot.boot.shiro.authorization.Authentication;
import com.ww.springboot.boot.system.mapper.UserRoleMapper;
import com.ww.springboot.boot.system.model.UserRoleMap;
import com.ww.springboot.boot.system.service.UserRoleMapService;


@Service
public class UserRoleMapServiceImpl implements UserRoleMapService {

	@Autowired
	private UserRoleMapper userRoleMapper;
	
	/**
	 * 根据用户id删除对应的记录
	 */
	@Transactional
	public int delete(Long userId) {
		return userRoleMapper.delete(userId);
	}

	@Override
	public int updateRoleByUserId(Long roleId, Long userId) {
		UserRoleMap userRoleMap = new UserRoleMap();
		userRoleMap.setRoleId(roleId);
		userRoleMap.setUserId(userId);
		userRoleMap.setCreateBy(Authentication.getUserName());
		userRoleMap.setCreateTime(new Date());
		return this.insert(userRoleMap);
	}

	@Transactional
	public int insert(UserRoleMap userRoleMap) {
		return userRoleMapper.insert(userRoleMap);
	}

	@Override
	public List<Long> findUserIdByRoleId(Long roleId) {
		
		return userRoleMapper.findUserIdByRoleId(roleId);
	}

	@Override
	public int deleteByroleId(Long roleId) {
		return userRoleMapper.deleteByroleId(roleId);
	}
}
