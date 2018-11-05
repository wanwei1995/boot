package com.ww.springboot.boot.system.service;

import java.util.List;

import com.ww.springboot.boot.system.model.User;


public interface UserService {

    /**
     * 条件查询
     * 
     * @author hhl
     * @date 2017/12/22
     */
    List<User> findBySelective(User user);

    /**
     * 更新用户所属角色 1.删除原有角色 2.插入新的角色
     * 
     * @author hhl
     * @date 2017/12/22
     */
    void updateUserRoles(String[] roleIds, Long userId);

    /**
     * 新增用户
     * 
     * @author hhl
     * @date 2017/12/22
     */
    Long insert(User user);

    /**
     * 批量禁用用户
     * 
     * @author hhl
     * @date 2017/12/22
     */
    Long forbidden(String[] ids);

    /**
     * 根据userId查询用户
     * 
     * @author hhl
     * @date 2017/12/22
     */
    User findById(Long userId);

    /**
     * 根据userName查找用户
     * 
     * @author hhl
     * @date 2017/12/25
     */
    User findByName(String userName);

    /**
     * 更新用户
     * 
     * @author hhl
     * @date 2017/12/22
     */
    Long update(User user);

    /**
     * 根据登录名和密码查找用户
     * 
     * @author hhl
     * @date 2017/12/28
     */
    User findByNameAndPwd(String userName, String oldPassword);

    /**
     * 根据用户名更新密码
     * 
     * @author hhl
     * @date 2017/12/28
     */
    Long updatePasswordByUserName(String userName, String newPassword);

    /**
     * 根据userId修改密码
     * 
     * @author hhl
     * @date 2017/12/28
     */
    Long updatePasswordByAdmin(Long userId, String password);

    /**
     * 锁定用户且错误次数加1
     * 
     * @author hhl
     * @param isLock
     * @date 2017/12/29
     */
    void lockUserByUserName(String name, long isLock);

    /**
     * 错误次数加1
     * 
     * @author hhl
     * @date 2017/12/29
     * @param name
     */
    void updateErrorCount(String loginName);

    /**
     * 错误次数清零
     * 
     * @author hhl
     * @date 2017/12/29
     * @param name
     */
    void clearErrorCount(String name);

    /**
     * 根据不同状态批量更新用户的锁定状态
     * 
     * @author hhl
     * @date 2017/12/29
     * @param ids
     * @param state
     */
    void updateLockState(String[] ids, Long state);

    /**
     * 不带is_deleted查找用户
     * 
     * @author hhl
     * @date 2018/01/03
     * @param loginName
     * @return
     */
    User findByNameWithoutDeleted(String loginName);
}
