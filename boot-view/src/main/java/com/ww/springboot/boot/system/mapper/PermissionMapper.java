package com.ww.springboot.boot.system.mapper;

import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ww.springboot.boot.system.dto.PermissionDto;
import com.ww.springboot.boot.system.model.Permission;
import com.ww.springboot.boot.utils.LanguageDriverUtil;

@Mapper
public interface PermissionMapper {

    @Select("select id,parent_id pId,code,name" + " from s_permission")
    List<PermissionDto> findAll();

    @Select("select parent_id as parentId,p.id,code,name from s_permission p inner join s_role_permission rp on p.id=rp.permission_id where rp.role_id=#{roleId}")
    Set<Permission> getPermissionsByRoleId(Long roleId);

    @Lang(LanguageDriverUtil.class)
    @Select("select parent_id as parentId,p.id,code,name from s_permission p inner join s_role_permission rp on p.id=rp.permission_id where rp.role_id in (#{roleIds})")
    Set<Permission> getPermissionsByRoleIds(@Param("roleIds") List<Long> roleIds);

    @Select("select parent_id as parentId,id,code,name from s_permission")
    Set<Permission> getAll();
}
