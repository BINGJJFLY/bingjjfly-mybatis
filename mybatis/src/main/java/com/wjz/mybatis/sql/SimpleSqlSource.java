package com.wjz.mybatis.sql;

import java.util.List;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

public class SimpleSqlSource implements SqlSource {

	private final String sql;
	private final List<ParameterMapping> parameterMappings;
	private final Configuration configuration;

	public SimpleSqlSource(Configuration configuration, String sql) {
		this(configuration, sql, null);
	}

	public SimpleSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
		this.sql = sql;
		this.parameterMappings = parameterMappings;
		this.configuration = configuration;
	}

	@Override
	public BoundSql getBoundSql(Object parameterObject) {
		return new BoundSql(configuration, sql, parameterMappings, parameterObject);
	}

}
