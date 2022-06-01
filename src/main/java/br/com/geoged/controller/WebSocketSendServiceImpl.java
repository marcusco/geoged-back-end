package br.com.geoged.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import br.com.geoged.util.PropertiesUtil;


public class WebSocketSendServiceImpl implements WebSocketSendService
{
	/**
	 * 
	 */
	//
	private String								url	= "ws://127.0.0.1:8080/rest/ws";
	private static StompSession			stompSession;
	private final WebSocketClient			webSocketClient;
	private final WebSocketStompClient	stompClient;
	private final StompSessionHandler	sessionHandler;
	//
	private WebSocketSendServiceImpl(PropertiesUtil env)
	{
		if(env != null)
		{
			url = env.load("system.ws.url");
		}
		List<Transport> transports = new ArrayList<Transport>();
		transports.add(new WebSocketTransport(new StandardWebSocketClient()));
		webSocketClient = new SockJsClient(transports);
		stompClient = new WebSocketStompClient(webSocketClient);
		sessionHandler = new CustomStompSessionHandler();
		try
		{
			stompSession = stompClient.connect(url, new WebSocketHttpHeaders(), sessionHandler).get();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static StompSession getInstance(PropertiesUtil env)
	{
		if(stompSession == null)
		{
			new WebSocketSendServiceImpl(env);
		}
		return stompSession;
	}
}
