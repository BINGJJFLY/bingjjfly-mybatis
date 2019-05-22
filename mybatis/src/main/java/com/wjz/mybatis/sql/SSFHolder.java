package com.wjz.mybatis.sql;

public class SSFHolder {
	
	public static final String SSF_1 = "ssf_1";
	public static final String SSF_2 = "ssf_2";
	
	private static final ThreadLocal<String> tl = new ThreadLocal<>();
	
	public static void setSSF(String ssf) {
		tl.set(ssf);
	}

	public static String getSSF() {
		return tl.get();
	}
	
	public static void clear() {
		tl.remove();
	}
}
