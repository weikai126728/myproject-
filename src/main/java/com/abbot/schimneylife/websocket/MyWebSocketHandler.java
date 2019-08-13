package com.abbot.schimneylife.websocket;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
/**
 * websocket 的处理类
 * @author Administrator
 *
 */
public class MyWebSocketHandler implements WebSocketHandler {

	private static final Logger logger = Logger.getLogger(MyWebSocketHandler.class);

	// 保存所有的用户session
	private static final ArrayList<WebSocketSession> users = new ArrayList<>();
	
	// 关闭 连接时
	@Override
	public void afterConnectionClosed(WebSocketSession arg0, CloseStatus arg1) throws Exception {
		logger.info("connect websocket closed.......");
		users.remove(arg0);
	}

	/**
	 * 连接就绪后
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession arg0) throws Exception {
		logger.info("connect websocket success.......");
		users.add(arg0);
	}
	// 处理信息
	@Override
	public void handleMessage(WebSocketSession arg0, WebSocketMessage<?> arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	public static void sendMessage(String message) throws IOException {
		for(WebSocketSession wss:users) {
			TextMessage textMessage = new TextMessage(message, true);
			wss.sendMessage(textMessage);
		}
	}
	public static ArrayList<WebSocketSession> getAllWebSocketSession(){
		return users;
	}
}
