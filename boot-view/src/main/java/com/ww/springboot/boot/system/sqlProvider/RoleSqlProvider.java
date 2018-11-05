package com.ww.springboot.boot.system.sqlProvider;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import com.ww.springboot.boot.system.model.Role;


public class RoleSqlProvider {

    private static final String TABLE_NAME = "s_role";

    private static final String ALL_FIELD =
            "id,name,create_time as createTime,create_by as createBy,update_time as "
                    + "updateTime,update_by as updateBy,is_deleted as isDeleted,version";

    public String findBySelective(Role role) {
        SQL sql = new SQL() {
            {
                SELECT(ALL_FIELD);
                FROM(TABLE_NAME);
                if (role.getId() != null) {
                    WHERE("id=#{id}");
                }
                if (StringUtils.hasText(role.getName())) {
                    WHERE("name=#{name}");
                }
                WHERE("is_deleted=0");
            }
        };
        return sql.toString();
    }
}
