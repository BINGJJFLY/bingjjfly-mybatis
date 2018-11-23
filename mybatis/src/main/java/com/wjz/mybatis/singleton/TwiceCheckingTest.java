package com.wjz.mybatis.singleton;

import com.wjz.mybatis.pojo.Person;

/**
 * 双重检测锁定式单例模式
 * 
 * @author iss002
 *
 */
public class TwiceCheckingTest {
	
	/**
	 * volatile关键字作用是禁止指令重排序
	 * 保证字段被初始化时单例对象已经被初始化
	 */
	private static volatile Person person = null;

	public static Person newInstance() {
		if (person == null) {
			synchronized (TwiceCheckingTest.class) {
				if (person == null) {
					person = new Person();
				}
			}
		}
		return person;
	}
}
