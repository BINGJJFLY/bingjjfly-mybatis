package com.wjz.mybatis.cache.references;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import org.junit.Test;

/**
 * 软引用
 * 
 * <p>如果对象被软引用，只有当Java虚拟机内存空间不足时执行GC才会回收该对象</p>
 *
 * @author iss002
 *
 */
public class SoftReferenceTest {

	@Test
	public void soft() {
		// SoftReferenceTest对象有两种引用，一种是强引用，一种是软引用
		SoftReferenceTest obj = new SoftReferenceTest();
		SoftReference<Object> soft = new SoftReference<>(obj);
		// 显示的中断对象的强引用，此时对象只有软引用了
		obj = null;
		SoftReferenceTest anotherObj = (SoftReferenceTest) soft.get();
		// 即使是强制执行GC对象依然没被回收
		System.gc();
		System.out.println(anotherObj);
	}
	
	@Test
	public void softQueue() {
		// 当 obj 对象被GC回收后，soft 软引用对象会被放到 queue 中
		SoftReferenceTest obj = new SoftReferenceTest();
		ReferenceQueue<Object> queue = new ReferenceQueue<>();
		SoftReference<Object> soft = new SoftReference<>(obj, queue);
		
		// 查看队列中是否有值，有值说明 obj 被GC回收，soft 软引用被放到了 queue 中，显示回收软引用
		while ((soft = (SoftReference<Object>) queue.poll()) != null) {
			try {
				queue.remove();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString() {
		return "hello Reference";
	}
}
