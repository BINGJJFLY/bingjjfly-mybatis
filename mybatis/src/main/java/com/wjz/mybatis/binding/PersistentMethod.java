package com.wjz.mybatis.binding;

import java.lang.reflect.Method;

import javax.sql.DataSource;

/**
 * 方法执行
 * <p>
 * Mybatis通过方法签名到缓存中找到MappedStatement，通过SQLSession执行sql
 * </p>
 * <p>
 * 我们也可以通过Xml配置方式放到缓存中，也可以通过注解方式
 * </p>
 * 
 * @author iss002
 *
 */
public class PersistentMethod {

	public PersistentMethod(Class<?> daoInterface, Method method) {
	}

	public Object execute(DataSource dataSource, Object[] args) {
		return null;
	}
}
