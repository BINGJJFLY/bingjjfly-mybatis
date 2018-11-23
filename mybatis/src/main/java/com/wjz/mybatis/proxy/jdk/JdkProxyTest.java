package com.wjz.mybatis.proxy.jdk;

//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;

import org.junit.Test;

import com.wjz.mybatis.proxy.Subject;
import com.wjz.mybatis.proxy.SubjectImpl;

/**
 * Jdk动态代理：Jdk动态生成Class字节，指定类加载器加载Class字节生成Java对象（代理对象），将InvokerHandler作为构造参数传入
 * 执行代理对象的方法时会调用InvokerHandler的invoke方法
 * 
 * @author iss002
 *
 */
public class JdkProxyTest {

	@Test
	public void jdkProxy() {
		CustomInvokerHandler handler = new CustomInvokerHandler(new SubjectImpl());
		Subject proxy = (Subject) handler.getProxy();
		proxy.operation();
	}
	
	/*
	 * 反编译代理对象的字节码如下：
	 * 
	public final class $Proxy4 extends Proxy {
		
		private static Method method;
		
		static {
			method = Class.forName("com.wjz.mybatis.proxy.Subject").getMethod("opertion", new Class[0]);
		}
		
		protected $Proxy4(InvocationHandler h) {
			super(h);
		}

		public final void operation() {
			super.h.invoke(this, method, (Object[]) null);
		}
	}
	*/
}
