package com.wjz.mybatis.reflection;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeParameterResolverDemo {

	public static void main(String[] args) {
		Method[] methods = TypeParameter.class.getMethods();
		for (Method method : methods) {
			if (TypeParameter.class == method.getDeclaringClass()) {
				Type returnType = method.getGenericReturnType();
				System.out.println(method.getName() + " ：" + returnType.getTypeName());
				Class<?> declaringClass = method.getDeclaringClass();
				System.out.println(method.getName() + " ：" + declaringClass);
				
				System.out.println(returnType instanceof TypeVariable);
				System.out.println(returnType instanceof ParameterizedType);
				System.out.println(returnType instanceof GenericArrayType);
				
				if ("string2".equals(method.getName())) {
					Type[] bounds = ((TypeVariable) returnType).getBounds();
					System.out.println(bounds[0]);
					
				}
			}
		}
	}
}
