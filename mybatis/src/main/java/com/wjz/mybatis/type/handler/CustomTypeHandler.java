package com.wjz.mybatis.type.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(String.class)
@MappedJdbcTypes({ JdbcType.NUMERIC, JdbcType.INTEGER, JdbcType.DOUBLE, JdbcType.DECIMAL })
public class CustomTypeHandler extends BaseTypeHandler<String> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {

	}

	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {

		return null;
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

		return null;
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

		return null;
	}

}
