package com.wjz.mybatis.reflection;

import java.util.List;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaClass;
import org.junit.Assert;
import org.junit.Test;

import com.wjz.mybatis.reflection.bridge.Child;

public class MetaClassTest {

	@Test
	public void findProperty() {
		MetaClass metaClass = MetaClass.forClass(Child.class, new DefaultReflectorFactory());
		
		Assert.assertEquals("name", metaClass.findProperty("name"));
		Assert.assertEquals("name", metaClass.findProperty("NaMe"));
	
		Assert.assertTrue(metaClass.hasGetter("name"));
		Assert.assertTrue(metaClass.hasSetter("name"));
		Assert.assertEquals(String.class, metaClass.getGetterType("name"));
		Assert.assertEquals(String.class, metaClass.getSetterType("name"));
		
		Assert.assertTrue(metaClass.hasGetter("innerChild"));
		Assert.assertTrue(metaClass.hasSetter("innerChild"));
		Assert.assertEquals(Child.class, metaClass.getGetterType("innerChild"));
		Assert.assertEquals(Child.class, metaClass.getSetterType("innerChild"));
		
		Assert.assertTrue(metaClass.hasGetter("innerChild.name"));
		Assert.assertTrue(metaClass.hasSetter("innerChild.name"));
		Assert.assertEquals(String.class, metaClass.getGetterType("innerChild.name"));
		Assert.assertEquals(String.class, metaClass.getSetterType("innerChild.name"));
		Assert.assertFalse(metaClass.hasGetter("innerChild.apple"));
		Assert.assertEquals("innerChild.name", metaClass.findProperty("innerChild.name"));
		Assert.assertEquals("innerChild.name", metaClass.findProperty("inner_Child.name", true));
	//	Assert.assertEquals(3, metaClass.getGetterNames().length);
		
		Assert.assertEquals(List.class, metaClass.getGetterType("parents"));
		
	}
}
