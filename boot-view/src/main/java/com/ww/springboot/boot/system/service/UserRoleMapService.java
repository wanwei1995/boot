package com.ww.springboot.boot.system.service;

import java.util.List;

public interface UserRoleMapService {

    /**
     * 根据用户id删除用户角色关联数据
     * 
     * @author hhl
     * @date 2017/12/22
     */
    int delete(Long userId);

    int deleteByroleId(Long roleId);

    /**
     * 根据用户id新增用户角色
     * 
     * @author hhl
     * @date 2017/12/22
     */
    int updateRoleByUserId(Long valueOf, Long userId);

    List<Long> findUserIdByRoleId(Long roleId);

}
