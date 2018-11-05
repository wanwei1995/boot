package com.ww.springboot.boot.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ww.springboot.boot.shiro.authorization.Authentication;
import com.ww.springboot.boot.system.mapper.UserMapper;
import com.ww.springboot.boot.system.model.User;
import com.ww.springboot.boot.system.service.UserRoleMapService;
import com.ww.springboot.boot.system.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapService userRoleMapService;
	
	@Override
	public List<User> findBySelective(User user) {
		return userMapper.findBySelective(user);
	}

	@Override
	@Transactional
	public void updateUserRoles(String[] roleIds, Long userId) {
		userRoleMapService.delete(Long.valueOf(userId));
		for(String roleId:roleIds) {
			userRoleMapService.updateRoleByUserId(Long.valueOf(roleId),Long.valueOf(userId));
		}
	}

	@Override
	@Transactional
	public Long insert(User user) {
		user.setCreateBy(Authentication.getUserName());
		user.setCreateTime(new Date());
		return userMapper.insertBySelective(user);
	}

	@Override
	@Transactional
	public Long forbidden(String[] ids) {
		return userMapper.forbidden(ids);
	}

	@Override
	public User findById(Long userId) {
		return userMapper.findById(userId);
	}

	@Override
	@Transactional
	public Long update(User user) {
		user.setUpdateBy(Authentication.getUserName());
		user.setUpdateTime(new Date());
		return userMapper.updateBySelective(user);
	}

	@Override
	public User findByName(String userName) {
		return userMapper.findByName(userName);
	}

	@Override
	public User findByNameAndPwd(String userName, String oldPassword) {
		return userMapper.findByNameAndPwd(userName, oldPassword);
	}

	@Override
	@Transactional
	public Long updatePasswordByUserName(String userName, String newPassword) {
		return userMapper.updatePasswordByUserName(userName, newPassword);
	}

	@Override
	@Transactional
	public Long updatePasswordByAdmin(Long userId, String password) {
		return userMapper.updatePasswordByAdmin(userId, password);
	}

	@Override
	@Transactional
	public void lockUserByUserName(String name, long isLock) {
		userMapper.lockUserByUserName(name, isLock);
	}

	@Override
	@Transactional
	public void updateErrorCount(String loginName) {
		userMapper.updateErrorCount(loginName);
	}

	@Override
	@Transactional
	public void clearErrorCount(String loginName) {
		userMapper.clearErrorCount(loginName);
	}

	@Override
	@Transactional
	public void updateLockState(String[] ids, Long state) {
		userMapper.updateLockState(ids, state);
	}

	@Override
	public User findByNameWithoutDeleted(String loginName) {
		return userMapper.findByNameWithoutDeleted(loginName);
	}
}
