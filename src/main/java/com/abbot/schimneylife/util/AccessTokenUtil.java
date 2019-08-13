package com.abbot.schimneylife.util;

public class AccessTokenUtil {

	private static String access_token = "";
	private static long date = 0l;
	
	public static void setToken(String token,long date) {
		AccessTokenUtil.access_token = token;
		AccessTokenUtil.date = date;
	}
	public static String getToken() {
		return AccessTokenUtil.access_token;
	}
	/**
	 * token 是否有效  true 有效   false 已失效
	 * @return
	 */
	public static boolean valid() {
		if("".equals(AccessTokenUtil.access_token)) {
			return false;
		}
		long now = System.currentTimeMillis();
		if(now-date>7200) {
			return false;
		}
		return true;
	}
}
