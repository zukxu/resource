package com.zukxu.resource.server;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * websocket服务
 * </p>
 *
 * @author zukxu
 * @date 2021/3/31 0031 14:56
 */
@Component
@ServerEndpoint("/websocket/{uid}")
public class WebSocketServer {
	/**
	 * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
	 */
	private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();

	/**
	 * 与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	private Session session;
	private String uid;

	/**
	 * 发送自定义消息
	 */
	public static void sendInfo(String message, @PathParam("uid") String uid) throws IOException {
		System.out.println("发送消息到:" + uid + "，报文:" + message);
		if (StringUtils.isNotBlank(uid) && webSocketMap.containsKey(uid)) {
			webSocketMap.get(uid).sendMessage(message);
		} else {
			System.out.println("用户" + uid + ",不在线！");
		}
	}

	@OnOpen
	public void oneOpen(Session session, @PathParam("uid") String uid) throws IOException {
		this.session=session;
		this.uid = uid;
		//将当前websocket对象加入set中
		webSocketMap.remove(uid);
		webSocketMap.put(uid,this);
		//	连接成功
		this.sendMessage("连接成功");
	}

	@OnClose
	public void onClose() {
		webSocketMap.remove(uid);
		System.out.println("关闭连接");
	}

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		this.sendMessage("服务端接收的消息:"+message);
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		System.out.println("发生错误:"+throwable.getMessage());
		throwable.printStackTrace();
	}

	/**
	 * 实现服务器主动推送
	 */
	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}
}
