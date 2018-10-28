package com.wjz.mybatis.reflection;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.invoker.Invoker;

import com.wjz.mybatis.reflection.bridge.Child;

/**
 * 属性对应的get方法的MethodInvoker设置到GetMethods后，
 * 属性对应的GetFieldInvoker不会再设置到GetMethods中
 * 
 * @author iss002
 *
 */
public class ReflectorDemo {

	public static void main(String[] args) {
		Reflector reflector = new Reflector(Child.class);
		boolean hasGetter = reflector.hasGetter("name");
		System.out.println("HasGetter：" + hasGetter);
		Invoker invoker = reflector.getGetInvoker("name");
		Child child = new Child();
		child.setName("iss002");
		try {
			Object name = invoker.invoke(child, null);
			System.out.println("Name：" + name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String property = reflector.findPropertyName("name");
		System.out.println("Property：" + property);
		
		// 加了缓存ConcurrentHashMap，将生成的Reflector缓存起来
		ReflectorFactory factory = new DefaultReflectorFactory();
		Reflector reflector2 = factory.findForClass(Child.class);
		boolean hasGetter2 = reflector2.hasGetter("name");
		System.out.println("HasGetter：" + hasGetter2);
		
		Reflector master = new Reflector(reflector.getClass());
		Invoker typeInvoker = master.getGetInvoker("type");
		try {
			Object type = typeInvoker.invoke(reflector, null);
			System.out.println(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
