package br.com.geoged.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.TenantId;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.exceptions.TenantIdExistsException;
import br.com.geoged.repositoty.TenantIdRepository;
import br.com.geoged.service.TenantIdService;


@Service
public class TenantIdServiceImpl extends ServiceBaseImpl<TenantId> implements TenantIdService
{
	@Autowired
	private TenantIdRepository tenantIdRepository;
	@Override
	public TenantId save(TenantId entity) throws GeoGedException
	{
		try
		{
			return tenantIdRepository.save(entity);
		}
		catch (Exception e)
		{
			throw new TenantIdExistsException();
		}
	}

	public Optional<TenantId> findById(Integer id)
	{
		return tenantIdRepository.findById(id);
	}

	@Override
	public void delete(TenantId entity) throws GeoGedException
	{
		tenantIdRepository.delete(entity);
	}

	@Override
	public List<TenantId> findAll(Integer tenantId)
	{
		return tenantIdRepository.findAll();
	}

	@Override
	public TenantId findByTenantId(Integer tenantId)
	{
		return tenantIdRepository.findByTenantId(tenantId);
	}

	@Override
	public List<TenantId> findByAll()
	{
		return tenantIdRepository.findByAll();
	}
}
