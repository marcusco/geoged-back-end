/**
 * Classe ListOfJson.java
 *
 * @author leonardo.chain
 *
 * @date 2017-01-21 23:02:55 
 */
package br.com.geoged.gson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public class ListOfJson<T> implements ParameterizedType
{
	private Class<?> wrapped;

	public ListOfJson(Class<T> wrapper)
	{
		this.wrapped = wrapper;
	}

	@Override
	public Type[] getActualTypeArguments()
	{
		return new Type[] {wrapped};
	}

	@Override
	public Type getRawType()
	{
		return List.class;
	}

	@Override
	public Type getOwnerType()
	{
		return null;
	}
}