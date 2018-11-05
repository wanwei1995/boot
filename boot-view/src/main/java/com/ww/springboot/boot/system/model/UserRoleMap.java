package com.ww.springboot.boot.system.model;

import com.ww.springboot.boot.model.BaseEntity;

public class UserRoleMap extends BaseEntity {

    private static final long serialVersionUID = 1130177015060822888L;

    /**
     * 
     */
    private Long id;

    /**
     * 用户表id
     */
    private Long userId;

    /**
     * 角色表id
     */
    private Long roleId;

    /**
     * 
     */
    private Integer isDeleted;

    /**
     * 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户表id
     * 
     * @return user_id 用户表id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户表id
     * 
     * @param userId 用户表id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 角色表id
     * 
     * @return role_id 角色表id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色表id
     * 
     * @param roleId 角色表id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    /**
     * 
     * @return is_deleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 
     * @param isDeleted
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
