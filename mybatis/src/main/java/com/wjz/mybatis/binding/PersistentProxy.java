package com.wjz.mybatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import javax.sql.DataSource;

public class PersistentProxy<D> implements InvocationHandler {
	
	// 代理目标接口，真正逻辑处理类
	private DataSource dataSource;
	private Class<D> daoInterface;
	private Map<Method, PersistentMethod> methodCache;

	public PersistentProxy(DataSource dataSource, Class<D> daoInterface, Map<Method, PersistentMethod> methodCache) {
		this.dataSource = dataSource;
		this.daoInterface = daoInterface;
		this.methodCache = methodCache;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// ==> 将<Method, PersistentMethod>放入到缓存中
		PersistentMethod persistentMethod = cachedMethod(method);
		return persistentMethod.execute(dataSource, args);
	}

	private PersistentMethod cachedMethod(Method method) {
		PersistentMethod persistentMethod = methodCache.get(method);
		if (persistentMethod == null) {
			persistentMethod = new PersistentMethod(daoInterface, method);
		}
		return persistentMethod;
	}
}
