package com.ww.springboot.boot.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ww.springboot.boot.system.model.UserRoleMap;

@Mapper
public interface UserRoleMapper {

    @Delete("delete from s_user_role where user_id=#{userId}")
    int delete(Long userId);

    @Insert("insert into s_user_role(role_id,user_id,create_by,create_time) values("
            + "#{roleId},#{userId},#{createBy},#{createTime})")
    int insert(UserRoleMap userRoleMap);

    @Select("select user_id userId from s_user_role where role_id = #{roleId}")
    List<Long> findUserIdByRoleId(Long roleId);

    @Delete("delete from s_user_role where role_id=#{roleId}")
    int deleteByroleId(Long roleId);

}
