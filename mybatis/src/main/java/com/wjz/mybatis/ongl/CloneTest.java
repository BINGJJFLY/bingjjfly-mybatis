package com.wjz.mybatis.ongl;

import org.junit.Test;

public class CloneTest {
	
	@Test
	public void clone1() {
		User user = new User();
		user.setId(10);
		user.setName("bingjjfly");
		System.out.println(user);
		User user2 = user;
		System.out.println(user2);
		user2.setId(11);
		System.out.println(user);
		System.out.println(user2);
	}

	@Test
	public void clone2() throws CloneNotSupportedException {
		User user = new User();
		user.setId(10);
		user.setName("bingjjfly");
		System.out.println(user);
		Object user2 = user.clone();
		System.out.println(user2);
	}
}
