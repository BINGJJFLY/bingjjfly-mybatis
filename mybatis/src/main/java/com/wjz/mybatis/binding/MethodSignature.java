package com.wjz.mybatis.binding;

import java.lang.reflect.Method;

/**
 * 面向对象，将方法签名封装成对象
 * 
 * @author iss002
 *
 */
public class MethodSignature {
	
	private String name;
	private Method method;
	private Class<?> returnType;
	private Class<?> declaringType;
	private int modifiers;

	public MethodSignature(Method method) {
		this.name = method.getName();
		this.method = method;
		this.returnType = method.getReturnType();
		this.declaringType = method.getDeclaringClass();
		this.modifiers = method.getModifiers();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Class<?> getReturnType() {
		return returnType;
	}

	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType;
	}

	public Class<?> getDeclaringType() {
		return declaringType;
	}

	public void setDeclaringType(Class<?> declaringType) {
		this.declaringType = declaringType;
	}

	public int getModifiers() {
		return modifiers;
	}

	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}

	@Override
	public String toString() {
		return "MethodSignature [name=" + name + ", method=" + method + ", returnType=" + returnType
				+ ", declaringType=" + declaringType + ", modifiers=" + modifiers + "]";
	}
	
}
