package com.wjz.mybatis.reflection.resolveType;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * TypeVariable内幕
 * 
 * @author iss002
 *
 */
public class TypeVariableDemo {

	public static void main(String[] args) throws Exception {
		Method method = ClassB.class.getDeclaredMethod("string", new Class<?>[] {});
		Type returnType = method.getGenericReturnType();
		System.out.println(returnType instanceof TypeVariable);
		System.out.println(returnType instanceof ParameterizedType);
		Type[] bounds = ((TypeVariable<?>) returnType).getBounds();
		System.out.println(bounds[0]);
		System.out.println(((TypeVariable<?>) returnType).getGenericDeclaration());
		System.out.println(((TypeVariable<?>) returnType).getName());
	}
}
