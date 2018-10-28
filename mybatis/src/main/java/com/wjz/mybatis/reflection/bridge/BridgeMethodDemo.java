package com.wjz.mybatis.reflection.bridge;

import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.MethodCallback;

public class BridgeMethodDemo {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Parent<String> parent = new Child();
		System.out.println(parent.bridgeMethod("123"));
		Class<? extends Parent> clz = parent.getClass();
		try {
			// 获得桥接方法
			Method method = clz.getMethod("bridgeMethod", Object.class);
			System.out.println("方法：" + getSignature(method) + " 是否为桥接方法：" + method.isBridge());
			// 获得bridgeMethod方法
			Method method2 = clz.getMethod("bridgeMethod", String.class);
			System.out.println("方法：" + getSignature(method2) + " 是否为桥接方法：" + method2.isBridge());

			Method[] methods = getClassMethods(clz);
			Method[] ms = getLocalMethods(clz);
			for (Method m : methods) {
				System.out.println(m.getDeclaringClass().getName());
				System.out.println("方法：" + getSignature(m) + " 是否为桥接方法：" + m.isBridge());
			}
			System.out.println("++++++++++++++++++++++");
			for (Method m : ms) {
				System.out.println(m.getDeclaringClass().getName());
				System.out.println("方法：" + getSignature(m) + " 是否为桥接方法：" + m.isBridge());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getSignature(Method method) {
		StringBuilder sb = new StringBuilder();
		Class<?> returnType = method.getReturnType();
		if (returnType != null) {
			sb.append(returnType.getName()).append('#');
		}
		sb.append(method.getName());
		Class<?>[] parameters = method.getParameterTypes();
		for (int i = 0; i < parameters.length; i++) {
			if (i == 0) {
				sb.append(':');
			} else {
				sb.append(',');
			}
			sb.append(parameters[i].getName());
		}
		return sb.toString();
	}

	private static Method[] getClassMethods(Class<?> cls) {
		Map<String, Method> uniqueMethods = new HashMap<String, Method>();
		Class<?> currentClass = cls;
		while (currentClass != null && currentClass != Object.class) {
			addUniqueMethods(uniqueMethods, currentClass.getDeclaredMethods());

			// we also need to look for interface methods -
			// because the class may be abstract
			Class<?>[] interfaces = currentClass.getInterfaces();
			for (Class<?> anInterface : interfaces) {
				addUniqueMethods(uniqueMethods, anInterface.getMethods());
			}

			currentClass = currentClass.getSuperclass();
		}

		Collection<Method> methods = uniqueMethods.values();

		return methods.toArray(new Method[methods.size()]);
	}

	private static void addUniqueMethods(Map<String, Method> uniqueMethods, Method[] methods) {
		for (Method currentMethod : methods) {
			if (!currentMethod.isBridge()) {
				String signature = getSignature(currentMethod);
				// check to see if the method is already known
				// if it is known, then an extended class must have
				// overridden a method
				if (!uniqueMethods.containsKey(signature)) {
					if (canAccessPrivateMethods()) {
						try {
							currentMethod.setAccessible(true);
						} catch (Exception e) {
							// Ignored. This is only a final precaution, nothing we can do.
						}
					}

					uniqueMethods.put(signature, currentMethod);
				}
			}
		}
	}

	private static boolean canAccessPrivateMethods() {
		try {
			SecurityManager securityManager = System.getSecurityManager();
			if (null != securityManager) {
				securityManager.checkPermission(new ReflectPermission("suppressAccessChecks"));
			}
		} catch (SecurityException e) {
			return false;
		}
		return true;
	}
	
	public static Method[] getLocalMethods(Class<?> clazz) {
		final List<Method> methods = new ArrayList<Method>(32);
		ReflectionUtils.doWithLocalMethods(clazz, new MethodCallback() {
			@Override
			public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
				methods.add(method);
			}
		});
		return methods.toArray(new Method[methods.size()]);
	}
}
