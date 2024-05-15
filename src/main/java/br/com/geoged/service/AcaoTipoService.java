package br.com.geoged.service;

import java.util.List;
import br.com.geoged.entity.AcaoTipo;
import br.com.geoged.exceptions.GeoGedException;


public interface AcaoTipoService extends IServiceBase<AcaoTipo>
{
	public AcaoTipo findByNome(Integer tenantId, String nome);

	public AcaoTipo findByTipo(Integer tenantId, Integer tipo);

	public AcaoTipo findById(Integer tenantId, Integer id);

	public List<AcaoTipo> findByTenantId(Integer tenantId) throws GeoGedException;
}
