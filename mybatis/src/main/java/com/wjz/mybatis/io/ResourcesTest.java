package com.wjz.mybatis.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.ibatis.io.Resources;
import org.junit.Test;

public class ResourcesTest {

	@Test
	public void getResourceURL() {
		String resource = "configuration.properties";
		try {
			// 通过类加载器获得资源文件的URL
			URL url = Resources.getResourceURL(resource);
			System.out.println("Url：" + url.toString());
			System.out.println("Protocol：" + url.getProtocol());
			System.out.println("Authority：" + url.getAuthority());
			System.out.println("File：" + url.getFile());
			System.out.println("Path：" + url.getPath());
			System.out.println("Host：" + url.getHost());
			System.out.println("Port：" + url.getPort());
			System.out.println("DefaultPort：" + url.getDefaultPort());
			System.out.println("Query：" + url.getQuery());
			System.out.println("Ref：" + url.getRef());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getResourceAsStream() {
		String resource = "configuration.properties";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
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
	
	@Test
	public void getUrlAsStream() {
		String resource = "configuration.properties";
		try {
			URL url = Resources.getResourceURL(resource);
			InputStream inputStream = Resources.getUrlAsStream(url.toString());
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
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
