/**
 * 
 */
package com.imooc.passbook.security;

/**
 * @author liforever
 * 用ThreadLocal 去单独存储每一个线程携带的token 信息
 * 2019年3月24日
 */
public class AccessContext {

	private static final ThreadLocal<String> token = new ThreadLocal<String>();

	public static String getToken() {
		return token.get();
	}
	public static void setToken(String tokenStr) {
		token.set(tokenStr);
	}
	public static void clearAccessKey() {
		token.remove();
	}
}
