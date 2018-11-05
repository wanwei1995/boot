package com.ww.springboot.boot.system.sqlProvider;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import com.ww.springboot.boot.system.model.User;

public class UserSqlProvider {

    private static final String TABLE_NAME = "s_user";

    private static final String ALL_FIELD =
            "id,login_name as loginName,display_name as displayName,"
                    + "password,error_count as errorCount,is_lock as isLock,expire_time as expireTime,create_time as createTime,"
                    + "create_by as createBy,update_time as updateTime,update_by as updateBy,is_deleted as isDeleted,version";

    public String findBySelective(User user) {

        SQL sql = new SQL() {
            {
                SELECT(ALL_FIELD);
                FROM(TABLE_NAME);
                if (user.getId() != null) {
                    WHERE("id=#{id}");
                }
                if (StringUtils.hasText(user.getLoginName())) {
                    WHERE("login_name=#{loginName}");
                }
                if (StringUtils.hasText(user.getDisplayName())) {
                    WHERE("display_name=#{displayName}");
                }
                if (StringUtils.hasText(user.getPassword())) {
                    WHERE("password=#{password}");
                }
                if (user.getErrorCount() != null) {
                    WHERE("error_count=#{errorCount}");
                }
                if (user.getIsLock() != null) {
                    WHERE("is_lock=#{isLock}");
                }
                if (user.getExpireTime() != null) {
                    WHERE("expire_time=#{expireTime}");
                }
                /*
                 * if(user.getCreateTime() != null) { WHERE("create_time=#{createTime}"); }
                 * if(StringUtils.hasText(user.getCreateBy())) { WHERE("create_by=#{createBy}"); }
                 * if(user.getUpdateTime() != null) { WHERE("update_time=#{updateTime}"); }
                 * if(StringUtils.hasText(user.getUpdateBy())) { WHERE("update_by=#{updateBy}"); }
                 * if(user.getIsDeleted() != null) { WHERE("is_deleted=#{isDeleted}"); }
                 * if(user.getVersion() != null) { WHERE("version=#{version}"); }
                 */
                WHERE("is_deleted=0");
            }
        };
        return sql.toString();
    }

    public String insertBySelective(User user) {

        SQL sql = new SQL() {
            {
                INSERT_INTO(TABLE_NAME);
                if (user.getId() != null) {
                    VALUES("id", "#{id}");
                }
                if (StringUtils.hasText(user.getLoginName())) {
                    VALUES("login_name", "#{loginName}");
                }
                if (StringUtils.hasText(user.getDisplayName())) {
                    VALUES("display_name", "#{displayName}");
                }
                if (StringUtils.hasText(user.getPassword())) {
                    VALUES("password", "#{password}");
                }
                if (user.getErrorCount() != null) {
                    VALUES("error_count", "#{errorCount}");
                }
                if (user.getIsLock() != null) {
                    VALUES("is_lock", "#{isLock}");
                }
                if (user.getExpireTime() != null) {
                    VALUES("expire_time", "#{expireTime}");
                }
                if (user.getCreateTime() != null) {
                    VALUES("create_time", "#{createTime}");
                }
                if (StringUtils.hasText(user.getCreateBy())) {
                    VALUES("create_by", "#{createBy}");
                }
            }
        };
        return sql.toString();
    }

    public String updateBySelective(User user) {

        SQL sql = new SQL() {
            {
                UPDATE(TABLE_NAME);
                if (StringUtils.hasText(user.getLoginName())) {
                    SET("login_name=#{loginName}");
                }
                if (StringUtils.hasText(user.getDisplayName())) {
                    SET("display_name=#{displayName}");
                }
                if (StringUtils.hasText(user.getPassword())) {
                    SET("password=#{password}");
                }
                if (user.getErrorCount() != null) {
                    SET("error_count=#{errorCount}");
                }
                if (user.getIsLock() != null) {
                    SET("is_lock=#{isLock}");
                }
                if (user.getExpireTime() != null) {
                    SET("expire_time=#{expireTime}");
                }
                if (user.getUpdateTime() != null) {
                    SET("update_time=#{updateTime}");
                }
                if (StringUtils.hasText(user.getUpdateBy())) {
                    SET("update_by=#{updateBy}");
                }
                if (user.getIsDeleted() != null) {
                    SET("is_deleted=#{isDeleted}");
                }
                if (user.getVersion() != null) {
                    SET("version=#{version}");
                }
                WHERE("id=#{id}");
            }
        };
        return sql.toString();
    }
}
