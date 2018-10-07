package com.wjz.mybatis.started;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wjz.mybatis.pojo.Person;

/**
 * 入门
 * 
 * @author iss002
 *
 */
public class GettingStarted {
	
	public static void main(String[] args) {
		String resource = "classpath:mybatis-config.xml";
		String statement = "";
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Person person = sqlSession.selectOne(statement, 1);
			System.out.println(person);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
