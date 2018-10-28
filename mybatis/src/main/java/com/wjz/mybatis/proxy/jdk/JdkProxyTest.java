package com.wjz.mybatis.proxy.jdk;

import org.junit.Test;

import com.wjz.mybatis.proxy.Subject;
import com.wjz.mybatis.proxy.SubjectImpl;

public class JdkProxyTest {

	@Test
	public void jdkProxy() {
		CustomInvokerHandler handler = new CustomInvokerHandler(new SubjectImpl());
		Subject proxy = (Subject) handler.getProxy();
		proxy.operation();
	}
}
