package com.ww.springboot.boot.system.model;

import com.ww.springboot.boot.model.BaseEntity;

/**
 * @author wanwei
 * @TODO 角色权限关联表
 * @date: 2017年12月20日 下午3:14:03
 */
public class RolePermission extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long roleId;

    private Long permissionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
