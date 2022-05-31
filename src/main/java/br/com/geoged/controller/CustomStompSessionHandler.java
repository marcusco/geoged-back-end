package br.com.geoged.controller;

import java.lang.reflect.Type;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

public class CustomStompSessionHandler  extends StompSessionHandlerAdapter
{
	 @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
    }
}
