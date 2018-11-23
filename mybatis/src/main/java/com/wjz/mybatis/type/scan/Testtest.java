package com.wjz.mybatis.type.scan;

import org.apache.ibatis.io.ResolverUtil.Test;

public class Testtest implements Test {

	@Override
	public boolean matches(Class<?> type) {
		if (type == Testtest.class) {
			return true;
		}
		return false;
	}

}
