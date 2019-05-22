package com.wjz.mybatis.builder;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.wjz.mybatis.pojo.Person;

public class EmptyList {

	@Test
	public void empty() {
		List<Person> persons = Collections.<Person> emptyList();
		Assert.assertEquals(0, persons.size());
	}
}
