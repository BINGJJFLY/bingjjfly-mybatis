package com.wjz.mybatis.reflection.resolveType;

import java.util.Map;

public class ClassA<K, V> {

	private Map<K, V> map;

	public Map<K, V> getMap() {
		return map;
	}

	public void setMap(Map<K, V> map) {
		this.map = map;
	}
	
}
