package com.wjz.mybatis.binding;

import java.lang.reflect.Method;

import javax.sql.DataSource;

public class PersistentMethod {

	public PersistentMethod(Class<?> daoInterface, Method method) {
	}

	public Object execute(DataSource dataSource, Object[] args) {
		return null;
	}
}
