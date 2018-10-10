package com.wjz.mybatis.reflection.bridge;

import java.lang.reflect.Method;

public class BridgeMethodDemo {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Parent<String> parent = new Child();
		System.out.println(parent.bridgeMethod("123"));
		Class<? extends Parent> clz = parent.getClass();
        try {
        	// 获得桥接方法
			Method method = clz.getMethod("bridgeMethod", Object.class);
			System.out.println(method.isBridge());
			// 获得bridgeMethod方法
			Method method2 = clz.getMethod("bridgeMethod", String.class);
			System.out.println(method2.isBridge());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
