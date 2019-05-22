package com.wjz.mybatis.cache.decorator;

/**
 * 装饰器
 * 
 * @author iss002
 *
 */
public class ConcreteDecorator implements Component {
	
	/**
	 * 被装饰对象
	 */
	private Component component;
	
	public ConcreteDecorator(Component component) {
		setComponent(component);
	}
	
	@Override
	public void operation() {
		component.operation();
	}
	
	public void setComponent(Component component) {
		this.component = component;
	}

}
