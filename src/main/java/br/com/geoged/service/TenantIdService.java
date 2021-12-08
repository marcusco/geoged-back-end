package br.com.geoged.service;

import java.util.List;
import br.com.geoged.entity.TenantId;


public interface TenantIdService extends IServiceBase<TenantId>
{
	public List<TenantId> findByTenantId(Integer tenantId);

	public List<TenantId> findByAll();
}
