package com.abbot.schimneylife.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户session管理
 * @author xinye
 *
 */
public class SessionManager {

	public enum Key{
		USER("user"),CUSTOMER("customer"),VERIFICATION("code"),TIMESTAMP("timestamp"),REDIRECTURL("redirectUrl")
		,FOOTMARKTIME("footmarktime"),ORDER("ORDER"),YINGLIORDER("YLORDER"),REDIRECTPARAMETER("redirectParameter"),DATELL("datell");
		private String value;
		private Key(String value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return this.value;
		}
		
	}
	/**
	 * 向session添加变量
	 * @param request
	 * @param key
	 * @param t
	 */
	public static <T> void addAttribute(HttpServletRequest request,SessionManager.Key key,T t) {
		HttpSession session = request.getSession();
		session.setAttribute(key.toString(), t);
	}
	
	public static String getRealPath(HttpServletRequest request) {
		return request.getSession().getServletContext().getRealPath("upload");
	}
	
	/**
	 * 根据key获取session中存储的数据
	 * @param request
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAttribute(HttpServletRequest request,SessionManager.Key key) {
		HttpSession session = request.getSession();
		return (T)session.getAttribute(key.toString());
	}
	public static void removeAttribute(HttpServletRequest request,SessionManager.Key key) {
		HttpSession session = request.getSession();
		session.removeAttribute(key.toString());
	}
	/**
	 * 清除session中user
	 * @param request
	 */
	public static void removeAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Enumeration<String> en = session.getAttributeNames();
		while(en.hasMoreElements()) {
			String k = en.nextElement();
			session.removeAttribute(k);
		}
		
	}
	public static boolean contains(HttpServletRequest request,SessionManager.Key key) {
		HttpSession session = request.getSession();
		Enumeration<String> en = session.getAttributeNames();
		while(en.hasMoreElements()) {
			String k = en.nextElement();
			if(k.equals(key.toString())) {
				return true;
			}
		}
		return false;
	}
	
}
