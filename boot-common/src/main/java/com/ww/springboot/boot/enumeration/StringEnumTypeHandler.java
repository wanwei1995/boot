package com.ww.springboot.boot.enumeration;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.util.StringUtils;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class StringEnumTypeHandler<E extends StringEnum> extends BaseTypeHandler<E> {

    private Class<E> type;

    public StringEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;

        E[] enums = type.getEnumConstants();
        if (enums == null) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            ps.setString(i, parameter.getValue());
        } else {
            ps.setObject(i, parameter.getValue(), jdbcType.TYPE_CODE); // see r3589
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
    	String string = rs.getString(columnName);
        try {
            return StringUtils.isEmpty(string) ? null : StringEnum.getEnum(type, string);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Cannot convert " + string + " to " + type.getSimpleName() + " by string value.", ex);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    	String string = rs.getString(columnIndex);

        try {
            return StringUtils.isEmpty(string) ? null : StringEnum.getEnum(type, string);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Cannot convert " + string + " to " + type.getSimpleName() + " by string value.", ex);
        }
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    	String string = cs.getString(columnIndex);

        try {
            return StringUtils.isEmpty(string) ? null : StringEnum.getEnum(type, string);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Cannot convert " + string + " to " + type.getSimpleName() + " by string value.", ex);
        }
    }
}
