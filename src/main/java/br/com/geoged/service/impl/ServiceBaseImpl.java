package br.com.geoged.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.IServiceBase;


public abstract class ServiceBaseImpl<T> implements IServiceBase<T>
{
	protected final Logger	logger			= LoggerFactory.getLogger(this.getClass());
	protected List<String>	messagesError	= new ArrayList<>();
	//
	protected ServiceBaseImpl()
	{
		super();
		createMessageError();
	}

	protected void beforeSave(T entity) throws GeoGedException
	{
	};

	protected void beforeSave(List<T> list) throws GeoGedException
	{
	};

	protected void afterSave(T entity) throws GeoGedException
	{
	};

	protected void afterSave(List<T> list) throws GeoGedException
	{
	};

	protected void validadeSave(T entity)
	{
	}

	public T save(T entity)
	{
		beforeSave(entity);
		return entity;
	}

	protected void beforeDelete(T entity) throws GeoGedException
	{
	};

	protected void afterDelete(T entity) throws GeoGedException
	{
	};

	private void createMessageError()
	{
		if(messagesError == null)
		{
			messagesError = new ArrayList<>();
		}
	}

	public List<String> getMessagesError()
	{
		return messagesError;
	}

	@Override
	public List<T> save(List<T> list) throws GeoGedException
	{
		beforeSave(list);
		return list;
	}

	@Override
	public Optional<T> findById(Integer id)
	{
		return null;
	}

	@Override
	public void delete(T entity) throws GeoGedException
	{
	}

	@Override
	public List<T> findAll(Integer tenantId)
	{
		return null;
	}
}
