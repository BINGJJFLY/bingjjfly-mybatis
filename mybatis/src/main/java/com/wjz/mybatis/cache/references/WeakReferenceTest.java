package com.wjz.mybatis.cache.references;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import org.junit.Test;

/**
 * 弱引用
 * 
 * <p>如果一个对象的所有引用都是弱引用，GC时无论内存是否充足对象都会被回收</p>
 *
 * @author iss002
 *
 */
public class WeakReferenceTest {

	@Test
	public void weak() {
		WeakReferenceTest test = new WeakReferenceTest();
		WeakReference<WeakReferenceTest> weak = new WeakReference<WeakReferenceTest>(test);
		test = null;
		System.out.println(weak.get());
		System.gc();
		System.out.println(weak.get());
	}
	
	@Test
	public void queue() {
		ReferenceQueue<Object> queue = new ReferenceQueue<>();
		WeakReference<WeakReferenceTest> weak = new WeakReference<WeakReferenceTest>(new WeakReferenceTest(), queue);
		System.out.println(weak.get());
		System.gc();
		System.out.println(weak.get());
		
		System.out.println(queue.poll());
		
		while ((weak = (WeakReference<WeakReferenceTest>) queue.poll()) != null) {
			try {
				queue.remove();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(queue.poll());
	}
	
	@Override
	public String toString() {
		return "Hello Reference";
	}
}
