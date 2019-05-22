package com.wjz.mybatis.cache.decorator;

/**
 * 具体的组件接口
 * 
 * @author iss002
 *
 */
public class ConcreteComponent implements Component {

	@Override
	public void operation() {
		System.out.println("concrete operation");
	}

}
