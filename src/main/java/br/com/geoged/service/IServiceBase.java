package br.com.geoged.service;

import java.util.List;
import java.util.Optional;
import br.com.geoged.exceptions.GeoGedException;


public interface IServiceBase<T>
{
	public abstract T save(T entity) throws GeoGedException;

	public abstract List<T> save(List<T> list) throws GeoGedException;

	public abstract Optional<T> findById(Integer id);

	public void delete(T entity) throws GeoGedException;

	public abstract List<T> findAll(Integer tenantId);
}
