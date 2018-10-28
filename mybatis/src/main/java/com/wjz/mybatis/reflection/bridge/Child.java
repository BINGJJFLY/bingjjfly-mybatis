package com.wjz.mybatis.reflection.bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>子类实现泛型类型接口</b>
 * <p>
 * 编译后生成一个默认的构造方法、bridgeMethod方法本身、桥接方法<br>
 * 桥接方法的签名为：public synthetic bridge Object bridgeMethod(Object param)
 * </p>
 * 
 * @author iss002
 *
 */
public class Child implements Parent<String> {
	
	private String name;
	
	private Child innerChild;
	
	private List<Parent> parents;

	/**
	 * 编译后的方法签名为：public String bridgeMethod(String param)
	 */
	@Override
	public String bridgeMethod(String t) {
		return t;
	}

	@Override
	public ArrayList<String> getMethod() {
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Child getInnerChild() {
		return innerChild;
	}

	public void setInnerChild(Child innerChild) {
		this.innerChild = innerChild;
	}

	public List<Parent> getParents() {
		return parents;
	}

	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}

}
