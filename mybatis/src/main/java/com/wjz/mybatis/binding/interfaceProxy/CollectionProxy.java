package com.wjz.mybatis.binding.interfaceProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class CollectionProxy<T> implements InvocationHandler {
	
	private List<T> target;
	
	public CollectionProxy(List<T> target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(target, args);
	}

}
