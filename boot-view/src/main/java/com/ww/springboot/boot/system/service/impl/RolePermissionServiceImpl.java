package com.ww.springboot.boot.system.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ww.springboot.boot.shiro.authorization.Authentication;
import com.ww.springboot.boot.system.mapper.RolePermissionMapper;
import com.ww.springboot.boot.system.model.RolePermission;
import com.ww.springboot.boot.system.service.RolePermissionService;


/**
 * @author wanwei
 * @TODO  角色权限关联
 * @date: 2017年12月22日 下午4:11:19 
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	
	public List<String> findByRoleId(String roleId) {
		return rolePermissionMapper.findByRoleId(roleId);
	}
	
	@Transactional
	public int insert(RolePermission rolePermission) {
		rolePermission.setCreateBy(Authentication.getUserName());
		rolePermission.setCreateTime(new Date());
		return rolePermissionMapper.insert(rolePermission);
	}

	@Transactional
	public int delete(String roleId) {
		return rolePermissionMapper.delete(roleId);
	}

	
	
}
