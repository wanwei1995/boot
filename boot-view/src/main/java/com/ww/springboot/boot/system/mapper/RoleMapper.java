package com.ww.springboot.boot.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.ww.springboot.boot.system.model.Role;
import com.ww.springboot.boot.system.sqlProvider.RoleSqlProvider;

@Mapper
public interface RoleMapper {

    @SelectProvider(type = RoleSqlProvider.class, method = "findBySelective")
    List<Role> findBySelective(Role role);


    @Select("select id,name,create_time as createTime,create_by as createBy,update_time as "
            + "updateTime,update_by as updateBy,is_deleted as isDeleted,version from s_role where is_deleted=0")
    List<Role> findAll();

    @Select("select s_role.id from s_role inner join s_user_role on s_role.id=s_user_role.role_id where s_user_role.user_id=#{userId}")
    List<Long> findRoleIdByUserId(Long userId);

    @Select("select s_role.name from s_role inner join s_user_role on s_role.id=s_user_role.role_id where s_user_role.user_id=#{userId}")
    List<String> findRoleNameByUserId(Long userId);

    @Select("select s_role.name as name,s_role.id as id from s_role inner join s_user_role on s_role.id=s_user_role.role_id where s_user_role.user_id=#{userId}")
    List<Role> findRoleByUserId(Long userId);

    @Update(" UPDATE s_role " + " SET is_deleted = 1 " + " WHERE id = #{roleId}")
    public void delete(Long roleId);

    @Insert("insert into s_role(name,create_time,create_by) values(#{name},#{createTime},#{createBy})")
    int add(Role role);


    @Select("select id,name from s_role where id = #{roleId} and is_deleted = 0")
    Role findById(Long id);

    @Select("select id,name from s_role where name = #{name} and is_deleted = 0")
    Role findByName(String name);
}
