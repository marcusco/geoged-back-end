package br.com.geoged.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessagesController
{
	
	 @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
		 //Thread.sleep(5000);
        return new Greeting(message.getName());
    }
	 
}
