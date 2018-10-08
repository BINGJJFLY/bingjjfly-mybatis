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
 * <p>
 * 遇到的问题：本地Oracle实例，修改sys密码<br> 
 * C:\WINDOWS\system32>cd C:\app\root\product\12.1.0\dbhome_1\BIN                          
 * C:\app\root\product\12.1.0\dbhome_1\BIN>sqlplus /nolog                                  
 * SQL*Plus: Release 12.1.0.2.0 Production on 星期一 10月 8 09:58:31 2018                      
 * Copyright (c) 1982, 2014, Oracle.  All rights reserved.                                 
 * SQL> connect / as sysdba                                                                
 * 已连接。                                                                                    
 * SQL> alter user sys identified by Oracle11g;                                            
 * 用户已更改。                                                                                  
 * SQL> exit                                                                               
 * 从 Oracle Database 12c Enterprise Edition Release 12.1.0.2.0 - 64bit Production          
 * With the Partitioning, OLAP, Advanced Analytics and Real Application Testing options 断开 
 * </p>
 * 
 * <p>
 * 上传Oracle驱动到本地仓库：
 * mvn install:install-file -Dfile=D:/ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc -Dversion=7 -Dpackaging=jar
 * </p>
 * 
 * @author iss002
 *
 */
public class GettingStarted {

	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		String statement = "com.wjz.mybatis.mapper.PersonMapper.selectById";
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
