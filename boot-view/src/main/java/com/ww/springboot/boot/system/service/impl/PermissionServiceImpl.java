package com.ww.springboot.boot.system.service.impl;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ww.springboot.boot.system.dto.PermissionDto;
import com.ww.springboot.boot.system.mapper.PermissionMapper;
import com.ww.springboot.boot.system.model.Permission;
import com.ww.springboot.boot.system.service.PermissionService;
import com.ww.springboot.boot.system.service.RolePermissionService;
import com.ww.springboot.boot.system.service.RoleService;

@Service
public class PermissionServiceImpl implements PermissionService {
    
	@Autowired
	private PermissionMapper permissionMapper;
	
	@Autowired
	private RolePermissionService rolePermissionService;

	@Autowired
	private RoleService roleService;

	//将权限表数据添加权限标识
	public List<PermissionDto> findAll(String roleId) {
		List<String> permissionIds = rolePermissionService.findByRoleId(roleId);
		List<PermissionDto>  permissionDtos = permissionMapper.findAll();
		for (String permissionId : permissionIds) {
			for (PermissionDto permissionDto : permissionDtos) {
				 if(permissionDto.getId().equals(permissionId)){
					 permissionDto.setChecked("true");
				 }	
			}	
		}

		// 管理员（admin）权限不能修改，初始化时会有所有权限
		// 权限取自s_permission中的所有值而不是通过关联查询
		if ("admin".equals(roleService.findById(Long.valueOf(roleId)).getName())) {
			for (PermissionDto permissionDto : permissionDtos) {
					permissionDto.setChecked("true");
					permissionDto.setChkDisabled(Boolean.TRUE);
			}
		}
		return permissionDtos;
	}
	
	@Override
	public Set<Permission> getPermissionsByRoleIds(List<Long> roleIds) {
		//批量查询，提高效率
		Set<Permission> permissions = permissionMapper.getPermissionsByRoleIds(roleIds);
		return permissions;
	}
	
	@Override
	public Set<Permission> getPermissionsByRoleId(Long roleId) {
		return permissionMapper.getPermissionsByRoleId(roleId);
	}

	@Override
	public Set<Permission> getAll() {
		return permissionMapper.getAll();
	}
}
