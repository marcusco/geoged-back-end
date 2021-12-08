package br.com.geoged.exceptions;

import java.util.Date;


public class ExceptionResponse
{
	/**
	* 
	*/
	private Date	timestamp;
	private String	mensage;
	private String	details;
	private String	httpCodeMessage;
	public ExceptionResponse(Date date, String message, String details, String httpCodeMessage)
	{
		super();
		this.timestamp = date;
		this.mensage = message;
		this.details = details;
		this.httpCodeMessage = httpCodeMessage;
	}

	public String getHttpCodeMessage()
	{
		return httpCodeMessage;
	}

	public Date getTimestamp()
	{
		return timestamp;
	}

	public String getMensage()
	{
		return mensage;
	}

	public String getDetails()
	{
		return details;
	}
}
