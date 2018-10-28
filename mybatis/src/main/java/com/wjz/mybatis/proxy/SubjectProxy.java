package com.wjz.mybatis.proxy;

public class SubjectProxy {

	private Subject subject;
	
	public SubjectProxy() {}
	
	public SubjectProxy(Subject subject) {
		this.subject = subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public void operation() {
		System.out.println("代理类中的前置处理");
		if (subject != null) {
			subject.operation();
			System.out.println("代理类中的后置处理");
		}
	}
}
