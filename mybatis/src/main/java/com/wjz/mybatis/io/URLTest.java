package com.wjz.mybatis.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class URLTest {

	@Test
	public void https() {
		try {
			URL url = new URL("https://github.com/BINGJJFLY?name=iss002");
			assertEquals("https://github.com/BINGJJFLY?name=iss002", url.toString());
			// 协议
			assertEquals("https", url.getProtocol());
			// 验证信息
			assertEquals("github.com", url.getAuthority());
			// 文件名及请求参数
			assertEquals("/BINGJJFLY?name=iss002", url.getFile());
			assertEquals("github.com", url.getHost());
			assertEquals("/BINGJJFLY", url.getPath());
			// 端口
			assertEquals(-1, url.getPort());
			// 默认端口，Https的默认端口为443，Http的默认端口为80
			assertEquals(443, url.getDefaultPort());
			// 请求参数
			assertEquals("name=iss002", url.getQuery());
			// 定位位置
			assertEquals(null, url.getRef());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void request() {
		try {
			URL url = new URL("http://www.west.com:7797/supply.do?name=iss002");
			assertEquals("http://www.west.com:7797/supply.do?name=iss002", url.toString());
			assertEquals("http", url.getProtocol());
			assertEquals("www.west.com:7797", url.getAuthority());
			assertEquals("/supply.do?name=iss002", url.getFile());
			assertEquals("www.west.com", url.getHost());
			assertEquals("/supply.do", url.getPath());
			assertEquals(7797, url.getPort());
			assertEquals(80, url.getDefaultPort());
			assertEquals("name=iss002", url.getQuery());
			assertEquals(null, url.getRef());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void connection() {
		try {
			URL url = new URL("https://github.com/BINGJJFLY");
			URLConnection connection = url.openConnection();
			assertEquals(true, connection instanceof HttpsURLConnection);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String urlString = "";
			String current;
			while ((current = in.readLine()) != null) {
				urlString += current;
			}
			System.out.println(urlString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
