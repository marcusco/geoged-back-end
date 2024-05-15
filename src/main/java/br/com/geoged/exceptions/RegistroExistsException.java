package br.com.geoged.exceptions;

public class RegistroExistsException extends GeoGedException
{
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	public RegistroExistsException()
	{
		super("registro.exists.exception");
	}
}
