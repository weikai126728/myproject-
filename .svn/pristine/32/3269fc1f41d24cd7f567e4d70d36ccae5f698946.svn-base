package com.abbot.schimneylife.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.util.SessionManager;
/**
 * springMVC拦截器 登陆验证、权限验证֤
 * @author xinye
 *
 */
public class CommonInterceptor implements HandlerInterceptor {	

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		User user = SessionManager.getAttribute(arg0, SessionManager.Key.USER);
		String uri = arg0.getRequestURI();
		if(user==null&&!uri.contains("/user/to/")) {//如果没有登陆跳转到登陆页面
			arg0.setAttribute("msg", "您还没有登陆请登录！");
			arg0.setAttribute("path", "manager/user/to/login.do");
			arg0.getRequestDispatcher("/manager/tips.jsp").forward(arg0, arg1);
		}
		return true;
	}
}
