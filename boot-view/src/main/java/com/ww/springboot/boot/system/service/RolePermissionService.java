package com.ww.springboot.boot.system.service;

import java.util.List;

import com.ww.springboot.boot.system.model.RolePermission;

public interface RolePermissionService {

    /**
     * @author wanwei
     * @TODO 通过roleId找permissionId
     * @date: 2017年12月22日 下午4:11:46
     */
    List<String> findByRoleId(String roleId);

    /**
     * @author wanwei
     * @TODO 插入角色与关联权限
     * @date: 2017年12月22日 下午4:13:19
     */
    int insert(RolePermission rolePermission);


    int delete(String roleId);

}
