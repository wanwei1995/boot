package com.ww.springboot.boot.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ww.springboot.boot.system.model.RolePermission;


@Mapper
public interface RolePermissionMapper {

    @Select("select permission_id from s_role_permission where role_id = #{roleId}")
    List<String> findByRoleId(String roleId);

    @Insert("insert into s_role_permission(role_id,permission_id)values(#{roleId},#{permissionId})")
    int insert(RolePermission rolePermission);

    @Delete("delete from s_role_permission " + " where role_id = #{roleId}")
    int delete(String roleId);

}
