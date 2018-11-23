package com.wjz.mybatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PersistentProxy<D> implements InvocationHandler {
	
	private Class<D> daoInterface;
	
	private final Map<Method, PersistentMethod> methodCache = new ConcurrentHashMap<>();

	public PersistentProxy(Class<D> daoInterface) {
		this.daoInterface = daoInterface;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return null;
	}
}
