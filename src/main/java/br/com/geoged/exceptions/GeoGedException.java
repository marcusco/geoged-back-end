package br.com.geoged.exceptions;

import br.com.geoged.util.GeoGedUtil;


public class GeoGedException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8437233443565097241L;
	//
	public GeoGedException(String message)
	{
		super(GeoGedUtil.getFormatedExceptionMessage(message));
	}
}
