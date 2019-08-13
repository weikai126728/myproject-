package com.abbot.schimneylife.websocket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.util.SessionManager;
/**
 * 握手拦截器，打通httpsession 和 websocketsession
 * @author Administrator
 *
 */
public class HandShakeInterceptor extends HttpSessionHandshakeInterceptor {
	
	/**
	 *握手后 
	 */
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		
		super.afterHandshake(request, response, wsHandler, ex);
	}
	/**
	 * 握手前
	 */
	@Override
	public boolean beforeHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2,
			Map<String, Object> arg3) throws Exception {
		//解决The extension [x-webkit-deflate-frame] is not supported问题  
        if(arg0.getHeaders().containsKey("Sec-WebSocket-Extensions")) {  
        	arg0.getHeaders().set("Sec-WebSocket-Extensions", "permessage-deflate");  
        }  
		ServletServerHttpRequest request = (ServletServerHttpRequest)arg0;
		User user = SessionManager.getAttribute(request.getServletRequest(), SessionManager.Key.USER);
		if(user!=null) {//用户已经登陆，标识 1
			arg3.put("isLogin", 1);
			arg3.put("userId", user.getId());
		}else {
			arg3.put("isLogin",0);
		}
		return super.beforeHandshake(arg0, arg1, arg2, arg3);
	}

	
}
