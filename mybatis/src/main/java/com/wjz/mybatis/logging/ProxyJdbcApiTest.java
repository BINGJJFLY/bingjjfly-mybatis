package com.wjz.mybatis.logging;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.logging.jdbc.ConnectionLogger;
import org.junit.Assert;
import org.junit.Test;

public class ProxyJdbcApiTest {

	@Test
	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "mybatis",
					"mybatis123");
			Log log = LogFactory.getLog(ProxyJdbcApiTest.class);
			// 创建Connection的代理类，执行prepareStatement方法时将传入的参数打印
			conn = ConnectionLogger.newInstance(conn, log, 0);
			// PreparedStatement（PreparedStatementLogger）也是代理对象
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM PERSON WHERE NAME = ? ");
			statement.setString(1, "iss002");
			// ResultSet（ResultSetLogger）也是代理对象
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String result = resultSet.getString("NAME");
				Assert.assertEquals("iss002", result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void removeBreakingWhitespace() {
		System.out.println(removeBreakingWhitespace("select    1 from dual"));
	}

	protected static String removeBreakingWhitespace(String original) {
		// 分词器
		StringTokenizer whitespaceStripper = new StringTokenizer(original);
		StringBuilder builder = new StringBuilder();
		while (whitespaceStripper.hasMoreTokens()) {
			builder.append(whitespaceStripper.nextToken());
			builder.append(" ");
		}
		return builder.toString();
	}

}
