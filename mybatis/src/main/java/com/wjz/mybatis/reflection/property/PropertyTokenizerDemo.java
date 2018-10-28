package com.wjz.mybatis.reflection.property;

import org.apache.ibatis.reflection.property.PropertyTokenizer;

public class PropertyTokenizerDemo {
	
	public static void main(String[] args) {
		String fullName = "orders[1].item[0].name";
		PropertyTokenizer tokenizer = new PropertyTokenizer(fullName);
		System.out.println("Name：" + tokenizer.getName());
		System.out.println("IndexedName：" + tokenizer.getIndexedName());
		System.out.println("Index：" + tokenizer.getIndex());
		System.out.println("Children：" + tokenizer.getChildren());
		System.out.println("HasNext：" + tokenizer.hasNext());
		
		while(tokenizer.hasNext()) {
			System.out.println("##########################################");
			tokenizer = tokenizer.next();
			PropertyTokenizer children = tokenizer;
			System.out.println("Name：" + children.getName());
			System.out.println("IndexedName：" + children.getIndexedName());
			System.out.println("Index：" + children.getIndex());
			System.out.println("Children：" + children.getChildren());
			System.out.println("HasNext：" + children.hasNext());
		}
		
		System.out.println();
		System.out.println("##########################################");
		System.out.println();
		
		String fullName2 = "order.name";
		PropertyTokenizer tokenizer2 = new PropertyTokenizer(fullName2);
		System.out.println("Name：" + tokenizer2.getName());
		System.out.println("IndexedName：" + tokenizer2.getIndexedName());
		System.out.println("Index：" + tokenizer2.getIndex());
		System.out.println("Children：" + tokenizer2.getChildren());
		System.out.println("HasNext：" + tokenizer2.hasNext());
		
		while(tokenizer2.hasNext()) {
			System.out.println("##########################################");
			tokenizer2 = tokenizer2.next();
			PropertyTokenizer children = tokenizer2;
			System.out.println("Name：" + children.getName());
			System.out.println("IndexedName：" + children.getIndexedName());
			System.out.println("Index：" + children.getIndex());
			System.out.println("Children：" + children.getChildren());
			System.out.println("HasNext：" + children.hasNext());
		}
	}

}
