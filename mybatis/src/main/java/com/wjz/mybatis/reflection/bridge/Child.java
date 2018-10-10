package com.wjz.mybatis.reflection.bridge;

/**
 * <b>子类实现泛型类型接口</b>
 * <p>
 * 编译后生成一个默认的构造方法、bridgeMethod方法本身、桥接方法<br>
 * 桥接方法的签名为：public synthetic bridge Object bridgeMethod(Object param)
 * </p>
 * 
 * @author iss002
 *
 */
public class Child implements Parent<String> {

	/**
	 * 编译后的方法签名为：public String bridgeMethod(String param)
	 */
	@Override
	public String bridgeMethod(String t) {
		return t;
	}

}
