package com.wjz.mybatis.reflection.property;

import org.apache.ibatis.reflection.property.PropertyNamer;
import org.junit.Test;

public class PropertyNamerDemo {
	
	@Test
	public void methodToProperty() {
		String name = "getAge";
		String property = PropertyNamer.methodToProperty(name);
		System.out.println(property);
		name = "getfOrderCode";
		property = PropertyNamer.methodToProperty(name);
		System.out.println(property);
	}

}
