package com.wjz.mybatis.reflection;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.ibatis.reflection.ParamNameUtil;
import org.junit.Assert;
import org.junit.Test;

import com.wjz.mybatis.pojo.Person;

public class ParamNameUtilTest {

	@Test
	public void paramName() {
		try {
			Method method = ParamNameUtilTest.class.getMethod("paramNames");
			List<String> paramNames = ParamNameUtil.getParamNames(method);
			Assert.assertEquals(3, paramNames.size());
			Assert.assertEquals("String", paramNames.get(0));
			Assert.assertEquals("com.wjz.mybatis.pojo.Person", paramNames.get(2));
		} catch (Exception e) {
		}
	}
	
	public void paramNames(String a, int b, Person p) {
		
	}
}
