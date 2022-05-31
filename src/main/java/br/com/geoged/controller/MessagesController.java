package br.com.geoged.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.exceptions.MessagesControllerException;


@RestController
public class MessagesController
{
	@MessageMapping("/hello")
	@SendTo("/topic/latlng")
	public Greeting greeting(Message message)
	{
		try
		{
			Thread.sleep(1000);
			return new Greeting(message.getName());
		}
		catch (Exception e)
		{
			throw new MessagesControllerException(e.getMessage());
		}
	}
}
