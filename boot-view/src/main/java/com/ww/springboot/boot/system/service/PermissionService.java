package com.ww.springboot.boot.system.service;

import java.util.List;
import java.util.Set;

import com.ww.springboot.boot.system.dto.PermissionDto;
import com.ww.springboot.boot.system.model.Permission;


/**
 * @author wanwei
 * @TODO 权限
 * @date: 2017年12月22日 下午4:10:12
 */
public interface PermissionService {

    List<PermissionDto> findAll(String roleId);

    /**
     * 根据角色id集合查找权限
     * 
     * @author hhl
     * @date 2017/12/25
     */
    Set<Permission> getPermissionsByRoleIds(List<Long> roleIds);

    /**
     * 根据角色id查找权限
     * 
     * @author hhl
     * @date 2017/12/25
     */
    Set<Permission> getPermissionsByRoleId(Long roleId);

    /**
     * 获取所有权限
     */
    Set<Permission> getAll();
}
