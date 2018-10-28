package com.wjz.mybatis.type.scan;

import java.lang.reflect.Modifier;
import java.util.Set;

import org.apache.ibatis.io.ResolverUtil;
import org.junit.Test;

import com.wjz.mybatis.type.scan.service.CommonService;

public class ScanServiceTest {

	@Test
	public void scan() {
		String packageName = "com/wjz/mybatis/type/scan";
		ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<Class<?>>();
		resolverUtil.find(new ResolverUtil.IsA(CommonService.class), packageName);
		Set<Class<? extends Class<?>>> handlerSet = resolverUtil.getClasses();
		for (Class<?> type : handlerSet) {
			// Ignore inner classes and interfaces (including package-info.java) and
			// abstract classes
			if (!type.isAnonymousClass() && !type.isInterface() && !Modifier.isAbstract(type.getModifiers())) {
				System.out.println(type.getName());
			}
		}
	}

}
