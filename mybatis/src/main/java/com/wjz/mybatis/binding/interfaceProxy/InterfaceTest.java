package com.wjz.mybatis.binding.interfaceProxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class InterfaceTest {

	@Test
	@SuppressWarnings("unchecked")
	public void coll() {
		List<String> target = new ArrayList<String>();
		CollectionProxy<String> handler = new CollectionProxy<String>(target);
		Collection<String> coll = (Collection<String>) Proxy.newProxyInstance(Collection.class.getClassLoader(),
				new Class[] { Collection.class }, handler);
		coll.add("String");
		coll.add("Interface");

		Assert.assertEquals(coll.size(), 2);

	}
}
