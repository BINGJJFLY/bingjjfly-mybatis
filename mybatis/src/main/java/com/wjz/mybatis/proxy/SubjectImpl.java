package com.wjz.mybatis.proxy;

public class SubjectImpl implements Subject {

	@Override
	public void operation() {
		System.out.println("具体实现类");
	}

}
