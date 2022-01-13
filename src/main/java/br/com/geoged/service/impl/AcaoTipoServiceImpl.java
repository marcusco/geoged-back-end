package br.com.geoged.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.AcaoTipo;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.exceptions.RegistroExistsException;
import br.com.geoged.repositoty.AcaoTipoRepository;
import br.com.geoged.service.AcaoTipoService;


@Service
public class AcaoTipoServiceImpl extends ServiceBaseImpl<AcaoTipo> implements AcaoTipoService
{
	@Autowired
	private AcaoTipoRepository acaoTipoRepository;
	@Override
	@Transactional(value = TxType.REQUIRED)
	public AcaoTipo save(AcaoTipo entity) throws GeoGedException
	{
		return acaoTipoRepository.save(entity);
	}

	public Optional<AcaoTipo> findById(Integer id)
	{
		return acaoTipoRepository.findById(id);
	}

	@Override
	public void delete(AcaoTipo entity) throws GeoGedException
	{
		acaoTipoRepository.delete(entity);
	}

	@Override
	public List<AcaoTipo> findByTenantId(Integer tenantId) throws GeoGedException
	{
		return Optional.of(acaoTipoRepository.findByTenant_id(tenantId)).orElseThrow(() -> new RegistroExistsException());
	}

	@Override
	public AcaoTipo findByNome(Integer tenantId, String nome)
	{
		return Optional.of(acaoTipoRepository.findByNome(tenantId, nome)).orElseThrow(() -> new GeoGedException("sem.dados"));
	}

	@Override
	public AcaoTipo findById(Integer tenantId, Integer id)
	{
		return acaoTipoRepository.findById(id).orElseThrow(() -> new GeoGedException("sem.dados"));
	}

	@Override
	public AcaoTipo findByTipo(Integer tenantId, Integer tipo)
	{
		return acaoTipoRepository.findByTipo(tenantId, tipo);
	}

	@Override
	protected void beforeSave(AcaoTipo entity) throws GeoGedException
	{
		if(entity.getNome().isBlank())
		{
			throw new GeoGedException("nome.obrigatorio.exception");
		}
		if(entity.getTipo() == null)
		{
			throw new GeoGedException("tipo.obrigatorio.exception");
		}
	}

	@Override
	protected void beforeDelete(AcaoTipo entity) throws GeoGedException
	{
		if(entity.getId() == null)
		{
			throw new GeoGedException("campos.obrigatorios");
		}
	}
}
