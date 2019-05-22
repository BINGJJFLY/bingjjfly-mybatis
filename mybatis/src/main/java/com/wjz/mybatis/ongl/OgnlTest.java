package com.wjz.mybatis.ongl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.junit.Before;
import org.junit.Test;


public class OgnlTest {
	
	private static Blog blog;
	private static Author author;
	private static List<Post> posts;
	private static OgnlContext context;
	
	@Before
	public void start() {
		Blog.staticField = "static field";
		author = new Author(1, "username", "password", "email");
		
		Post post = new Post();
		post.setContent("content");
		post.setAuthor(author);
		
		posts = new ArrayList<>();
		posts.add(post);
		blog = new Blog(1, "title", author, posts);
		
		context = new OgnlContext();
		context.put("blog", blog);
		context.setRoot(blog);
	}
	
	@Test
	public void test1() throws OgnlException {
		Author author = new Author(2, "username2", "password2", "email2");
		context.put("author", author);
		
		Object obj = Ognl.getValue(Ognl.parseExpression("author"), context, context.getRoot());
		System.out.println(obj);
		
		obj = Ognl.getValue(Ognl.parseExpression("author.username"), context, context.getRoot());
		System.out.println(obj);
		
		obj = Ognl.getValue(Ognl.parseExpression("#author.username"), context, context.getRoot());
		System.out.println(obj);
		
		obj = Ognl.getValue(Ognl.parseExpression("author.username"), context);
		System.out.println(obj);
		
		obj = Ognl.getValue(Ognl.parseExpression("author.username != null"), context);
		System.out.println(obj);
		
		obj = Ognl.getValue(Ognl.parseExpression("author.username != null && author.username != '' "), context);
		System.out.println(obj);
		
		obj = Ognl.getValue(Ognl.parseExpression("author.username != null and author.username != '' "), context);
		System.out.println(obj);
	}
	
	@Test
	public void test2() throws OgnlException {
		Object obj = Ognl.getValue(Ognl.parseExpression("author.getEmail()"), context, context.getRoot());
		System.out.println(obj);
		
		obj = Ognl.getValue(Ognl.parseExpression("@com.wjz.mybatis.ongl.Blog@staticMethod()"), context, context.getRoot());
		System.out.println(obj);
		
		obj = Ognl.getValue(Ognl.parseExpression("@com.wjz.mybatis.ongl.Blog@staticField"), context, context.getRoot());
		System.out.println(obj);
		
		obj = Ognl.getValue(Ognl.parseExpression("@com.wjz.mybatis.ongl.Blog@staticField"), context);
		System.out.println(obj);
	}

}
