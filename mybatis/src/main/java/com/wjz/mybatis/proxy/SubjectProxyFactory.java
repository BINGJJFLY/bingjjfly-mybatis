package com.wjz.mybatis.proxy;

public final class SubjectProxyFactory {
	
	public static SubjectProxy createProxy(Subject subject) {
		return new SubjectProxy(subject);
	}

}
