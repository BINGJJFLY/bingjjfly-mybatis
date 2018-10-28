package com.wjz.mybatis.reflection.resolveType;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import org.apache.ibatis.reflection.TypeParameterResolver;

/**
 * ParameterizedType内幕
 * 
 * @author iss002
 *
 */
public class ParameterizedTypeDemo {

	SubClassA<Long> sub = new SubClassA<>();

	public static void main(String[] args) throws Exception {
		Field f = ClassA.class.getDeclaredField("map");
		System.out.println(f.getGenericType());
		System.out.println(f.getGenericType() instanceof ParameterizedType);
		System.out.println(f.getGenericType() instanceof TypeVariable);

		Type type = TypeParameterResolver.resolveFieldType(f, ParameterizedTypeDemo.class.getDeclaredField("sub").getGenericType());
		System.out.println(type.getClass());

		ParameterizedType p = (ParameterizedType) type;
		System.out.println(p.getRawType());
		System.out.println(p.getOwnerType());
		for (Type t : p.getActualTypeArguments()) {
			System.out.println(t);
		}
	}
}
