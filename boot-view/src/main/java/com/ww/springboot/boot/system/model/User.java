package com.ww.springboot.boot.system.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ww.springboot.boot.model.BaseEntity;

public class User extends BaseEntity {

    private static final long serialVersionUID = -149676871675442367L;

    /**
     * 
     */
    private Long id;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 展示名称
     */
    private String displayName;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录失败次数
     */
    private Long errorCount;

    /**
     * 是否锁定：0否，1是，错误次数到一定值会锁定
     */
    private Integer isLock;

    /**
     * 过期时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expireTime;

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
     * 登录名称
     * 
     * @return login_name 登录名称
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录名称
     * 
     * @param loginName 登录名称
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 展示名称
     * 
     * @return display_name 展示名称
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 展示名称
     * 
     * @param displayName 展示名称
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    /**
     * 密码
     * 
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * 
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 登录失败次数
     * 
     * @return error_count 登录失败次数
     */
    public Long getErrorCount() {
        return errorCount;
    }

    /**
     * 登录失败次数
     * 
     * @param errorCount 登录失败次数
     */
    public void setErrorCount(Long errorCount) {
        this.errorCount = errorCount;
    }

    /**
     * 过期时间
     * 
     * @return expire_time 过期时间
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 过期时间
     * 
     * @param expireTime 过期时间
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
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

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

}
