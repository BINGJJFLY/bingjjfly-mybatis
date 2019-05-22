package com.wjz.mybatis.cache.references;

/**
 * 强引用
 * 
 * <p>如果对象被强引用，即使Java虚拟机内存空间不足时GC也不会回收该对象</p>
 *
 * @author iss002
 *
 */
public class StrongReferenceTest {

	public static void main(String[] args) {
		new StrongReferenceTest().recycleObj();
	}
	
	/**
	 * 该方法执行完后，对象都会被回收
	 */
	public void recycleObj() {
		Object obj = new Object();
		// 即使此时JVM内存溢出之后也不会回收 obj 指向的对象
		Object[] objs = new Object[100000];
	}
}
