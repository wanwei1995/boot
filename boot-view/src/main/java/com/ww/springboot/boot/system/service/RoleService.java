package com.ww.springboot.boot.system.service;

import java.util.List;

import com.ww.springboot.boot.system.model.Role;

/**
 * @author wanwei
 * @TODO 用户角色
 * @date: 2017年12月22日 下午4:07:35
 */
public interface RoleService {

    /**
     * 条件查询
     * 
     * @author hhl
     * @date 2017/12/22
     */
    List<Role> findBySelective(Role role);

    /**
     * 查询所有角色
     * 
     * @author hhl
     * @date 2017/12/22
     */
    List<Role> findAll();

    /**
     * 根据用户id查找对应的角色id
     * 
     * @author hhl
     * @date 2017/12/22
     */
    List<Long> findRoleIdByUserId(Long userId);

    /**
     * 根据用户id查找对应的角色名称
     * 
     * @author hhl
     * @date 2017/12/22
     */
    List<String> findRoleNameByUserId(Long userId);

    /**
     * 根据用户id查找对应的角色
     * 
     * @author hhl
     * @date 2017/12/22
     */
    List<Role> findRoleByUserId(Long userId);

    /**
     * @author wanwei
     * @TODO
     * @date: 2017年12月22日 下午3:01:28
     * @param ids
     * @return
     */
    String update(String ids);

    /**
     * @author wanwei
     * @TODO id找role
     * @date: 2017年12月22日 下午4:04:36
     * @param id
     * @return
     */
    Role findById(Long id);

    /**
     * @author wanwei
     * @TODO 名称找role
     * @date: 2017年12月22日 下午4:04:54
     * @param name
     * @return
     */
    Role findByName(String name);

    /**
     * @author wanwei
     * @TODO 单条删除
     * @date: 2017年12月22日 下午4:05:17
     * @param id
     * @return
     */
    void delete(Long id);

    /**
     * @author wanwei
     * @TODO 多条删除
     * @date: 2017年12月22日 下午4:05:32
     * @param idArray
     * @return
     */
    void deleteList(String[] idArray);

    /**
     * @author wanwei
     * @TODO 新增角色
     * @date: 2017年12月22日 下午4:05:53
     * @param role
     * @return
     */
    boolean add(Role role);

}
