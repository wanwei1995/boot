package com.ww.springboot.boot.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.ww.springboot.boot.system.model.User;
import com.ww.springboot.boot.system.sqlProvider.UserSqlProvider;

@Mapper
public interface UserMapper {

    @SelectProvider(type = UserSqlProvider.class, method = "findBySelective")
    public List<User> findBySelective(User user);

    @SelectProvider(type = UserSqlProvider.class, method = "insertBySelective")
    public Long insertBySelective(User user);

    @Update("<script>" + "update s_user set is_deleted='1' where id in"
            + "<foreach collection=\"ids\" item=\"item\" index=\"index\" open=\"(\" separator=\",\" close=\")\">#{item}</foreach>"
            + "</script>")
    public Long forbidden(@Param("ids") String[] ids);

    @Select("select id,login_name as loginName,display_name as displayName,password,error_count as errorCount,is_lock as isLock,expire_time as expireTime,"
            + "create_time as createTime,create_by as createBy,update_time as updateTime,update_by as updateBy,is_deleted as isDeleted,version from s_user where id=#{userId} and is_deleted=0")
    public User findById(Long userId);

    @SelectProvider(type = UserSqlProvider.class, method = "updateBySelective")
    public Long updateBySelective(User user);

    @Select("select id,login_name as loginName,display_name as displayName,password,error_count as errorCount,is_lock as isLock,expire_time as expireTime,"
            + "create_time as createTime,create_by as createBy,update_time as updateTime,update_by as updateBy,is_deleted as isDeleted,version from s_user where login_name=#{userName} "
            + "and is_deleted=0")
    public User findByName(String userName);

    @Select("select id,login_name as loginName,display_name as displayName,password,error_count as errorCount,is_lock as isLock,expire_time as expireTime,"
            + "create_time as createTime,create_by as createBy,update_time as updateTime,update_by as updateBy,is_deleted as isDeleted,version from s_user where login_name=#{userName} and password=#{oldPassword} and is_deleted=0")
    public User findByNameAndPwd(@Param("userName") String userName,
            @Param("oldPassword") String oldPassword);

    @Update("update s_user set password=#{newPassword} where login_name=#{userName} and is_deleted=0")
    public Long updatePasswordByUserName(@Param("userName") String userName,
            @Param("newPassword") String newPassword);

    @Update("update s_user set password=#{password} where id=#{userId} and is_deleted=0")
    public Long updatePasswordByAdmin(@Param("userId") Long userId,
            @Param("password") String password);

    @Update("update s_user set error_count=error_count+1,is_lock=#{isLock} where login_name=#{name}")
    public void lockUserByUserName(@Param("name") String name, @Param("isLock") long isLock);

    @Update("update s_user set error_count=error_count+1 where login_name=#{loginName}")
    public void updateErrorCount(String loginName);

    @Update("update s_user set error_count=0 where login_name=#{loginName}")
    public void clearErrorCount(String loginName);

    @Update("<script>" + "update s_user set is_lock=#{state} where id in"
            + "<foreach collection=\"ids\" item=\"item\" index=\"index\" open=\"(\" separator=\",\" close=\")\">#{item}</foreach>"
            + "</script>")
    public void updateLockState(@Param("ids") String[] ids, @Param("state") Long state);

    @Select("select id,login_name as loginName,display_name as displayName,password,error_count as errorCount,is_lock as isLock,expire_time as expireTime,"
            + "create_time as createTime,create_by as createBy,update_time as updateTime,update_by as updateBy,is_deleted as isDeleted,version from s_user where login_name=#{userName}")
    public User findByNameWithoutDeleted(String loginName);
}
