package com.wjz.mybatis.singleton;

import com.wjz.mybatis.pojo.Person;

/**
 * 静态内部类方式单例模式
 * 
 * @author iss002
 *
 */
public abstract class StaticInnerTest {

	// 私有的静态内部类，只会在newInstance方法中被使用
	private static class PersonHondler {
		// 访问静态内部类的静态字段时静态内部类才会被初始化
		// 类加载机制保证类只加载一次即保证线程安全
		public static final Person person = new Person();
	}

	public static Person newInstance() {
		return PersonHondler.person;
	}

}
