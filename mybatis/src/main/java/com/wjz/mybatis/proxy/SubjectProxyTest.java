package com.wjz.mybatis.proxy;

import org.junit.Test;

public class SubjectProxyTest {

	/**
	 * 静态代理模式
	 */
	@Test
	public void staticProxy() {
		SubjectProxy proxy = SubjectProxyFactory.createProxy(new SubjectImpl());
		proxy.operation();
	}
}
