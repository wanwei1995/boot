package com.ww.springboot.boot.system.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ww.springboot.boot.shiro.authorization.Authentication;
import com.ww.springboot.boot.shiro.authorization.MyShiroRealm;
import com.ww.springboot.boot.shiro.cache.RedisCacheManager;
import com.ww.springboot.boot.system.mapper.RoleMapper;
import com.ww.springboot.boot.system.model.Role;
import com.ww.springboot.boot.system.model.RolePermission;
import com.ww.springboot.boot.system.service.RolePermissionService;
import com.ww.springboot.boot.system.service.RoleService;
import com.ww.springboot.boot.system.service.UserRoleMapService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private MyShiroRealm myShiroRealm;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private UserRoleMapService userRoleMapService;

	@Autowired
	private RolePermissionService rolePermissionService;

	public List<Role> findBySelective(Role role) {
		return roleMapper.findBySelective(role);
	}

	@Override
	@Transactional
	public String update(String ids) {
		String[] idArray = ids.split("#");
		String roleId = idArray[0];
		rolePermissionService.delete(roleId);
		RolePermission rolePermission = new RolePermission();
		rolePermission.setRoleId(Long.valueOf(roleId));
		String permissions = idArray[1];
		String[] perArray = permissions.split(",");
		for (String perId : perArray) {
			rolePermission.setPermissionId(Long.valueOf(perId));
			rolePermissionService.insert(rolePermission);
		}
		// 查出所有拥有这个角色的用户
		List<Long> users = userRoleMapService.findUserIdByRoleId(Long.valueOf(roleId));
		for (Long userId : users) {
			clearPermissionCache(userId);
		}
		return null;
	}

	@Transactional
	public boolean add(Role role) {
		Role roler = findByName(role.getName());
		if (roler != null) {
			return false;
		}
		role.setCreateBy(Authentication.getUserName());
		role.setCreateTime(new Date());
		roleMapper.add(role);
		return true;
	}

	@Transactional
	public void deleteList(String[] idArray) {
		for (String roleId : idArray) {
			// 删除用户与角色表中与角色相关的数据  userRole
			userRoleMapService.deleteByroleId(Long.valueOf(roleId));
            
			// 查出所有拥有这个角色的用户  
			// 清空redis
			List<Long> users = userRoleMapService.findUserIdByRoleId(Long.valueOf(roleId));
			for (Long userId : users) {
				clearPermissionCache(userId);
			}
			// 删除角色
			delete(Long.valueOf(roleId));

			// 删除角色拥有的权限
			rolePermissionService.delete(roleId);
		}
	}

	@Transactional
	public void delete(Long id) {
		roleMapper.delete(id);
	}

	public Role findById(Long id) {
		return roleMapper.findById(id);
	}

	@Override
	public Role findByName(String name) {
		return roleMapper.findByName(name);
	}

	@Override
	public List<Role> findAll() {
		return roleMapper.findAll();
	}

	@Override
	public List<Long> findRoleIdByUserId(Long userId) {
		return roleMapper.findRoleIdByUserId(userId);
	}

	@Override
	public List<String> findRoleNameByUserId(Long userId) {
		return roleMapper.findRoleNameByUserId(userId);
	}
	
	@Override
	public List<Role> findRoleByUserId(Long userId) {
		return roleMapper.findRoleByUserId(userId);
	}

	// 清空redis
	public void clearPermissionCache(Long userId) {
		((RedisCacheManager) cacheManager).getCache(myShiroRealm.getAuthorizationCacheName()).remove(userId);
	}
}
