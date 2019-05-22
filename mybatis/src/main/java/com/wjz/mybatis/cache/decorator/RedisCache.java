package com.wjz.mybatis.cache.decorator;

import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;

public class RedisCache implements Cache {

	@Override
	public String getId() {
		return null;
	}

	@Override
	public void putObject(Object key, Object value) {
		
	}

	@Override
	public Object getObject(Object key) {
		return null;
	}

	@Override
	public Object removeObject(Object key) {
		return null;
	}

	@Override
	public void clear() {
		
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return null;
	}

}
