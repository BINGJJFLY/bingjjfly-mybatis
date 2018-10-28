package com.wjz.mybatis.type.map;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import org.apache.ibatis.type.JdbcType;
import org.junit.Assert;
import org.junit.Test;

public class EnumMapAndEmptyMap {

	@Test
	public void enumMap() {
		Map<JdbcType, String> map = new EnumMap<>(JdbcType.class);
		map.put(JdbcType.INTEGER, "8");
		Assert.assertEquals("8", map.get(JdbcType.INTEGER));
	}
	
	@Test
	public void emptyMap() {
		/**
		 * 空的Map集合，几乎不占用内存，比初始化要节省内存，但是不能添加元素
		 * 方法返回类型是Map，有没有结果值都不能返回null时可使用
		 * 同Collections.emptyList()
		 */
		Map<String, Object> map = Collections.emptyMap();
		Assert.assertEquals("java.util.Collections$EmptyMap", map.getClass().getName());
	}
}
