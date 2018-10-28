package com.wjz.mybatis.reflection;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.junit.Assert;
import org.junit.Test;

import com.wjz.mybatis.pojo.RichType;

public class MetaObjectTest {

	@Test
	public void shouldGetAndSetMapPairUsingArraySyntax() {
		RichType object = new RichType();
		MetaObject metaObject = SystemMetaObject.forObject(object);
		metaObject.setValue("richMap[fOrderCode]", "YFK20181017001");
		Assert.assertEquals("YFK20181017001", metaObject.getValue("richMap[fOrderCode]"));
	}

	@Test
	public void shouldGetAndSetNestedMapPair() {
		RichType rich = new RichType();
		MetaObject meta = SystemMetaObject.forObject(rich);
		meta.setValue("richType.richMap.fOrderCode", "YFK20181017001");
		Assert.assertEquals("YFK20181017001", meta.getValue("richType.richMap.fOrderCode"));
	}

	@Test
	  public void shouldDemonstrateDeeplyNestedMapProperties() {
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    MetaObject metaMap = SystemMetaObject.forObject(map);
	    metaMap.setValue("name.first", "wang jz");
	    
	    Map<String, Object> name = (Map<String, Object>) metaMap.getValue("name");
	    Assert.assertEquals("wang jz", name.get("first"));
	    
	    Assert.assertEquals("wang jz", metaMap.getValue("name.first"));
	}

}
