package com.wjz.mybatis.cache.lru;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 近期最少使用
 * 
 * @author iss002
 *
 */
public class LruLinkedHashMapTest {

	private int size = 5;
	private Object eldestKey;
	private Map<Object, Object> map;

	@Test
	public void demo() {
		map = new LinkedHashMap<Object, Object>(size, .75F, true) {

			private static final long serialVersionUID = -6501534326193136582L;

			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<Object, Object> eldest) {
				boolean enough = size() > size;
				if (enough) {
					eldestKey = eldest.getKey();
				}
				return enough;
			}

		};
		for (int i = 0; i < 5; i++) {
			put(i);
			setEldestKeyNull();
		}
		assertEquals(null, map.get(eldestKey));
		assertEquals(0, map.get(0));
		put(5);
		assertNotNull("eldestKey not null", eldestKey);
		setEldestKeyNull();
		assertNull("eldestKey null", eldestKey);
	}

	private void setEldestKeyNull() {
		if (eldestKey != null) {
			eldestKey = null;
		}
	}

	private void put(int i) {
		map.put(i, i);
	}

}
