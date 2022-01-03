package br.com.geoged.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.Colaborador;
import br.com.geoged.repositoty.ColaboradorRepository;
import br.com.geoged.service.ColaboradorService;


@Service
public class ColaboradorServiceImpl extends ServiceBaseImpl<Colaborador> implements ColaboradorService
{
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	@Override
	public Colaborador save(Colaborador entity)
	{
		return colaboradorRepository.save(entity);
	}

	public Optional<Colaborador> findById(Integer id)
	{
		return colaboradorRepository.findById(id);
	}

	@Override
	public void delete(Colaborador entity)
	{
		colaboradorRepository.delete(entity);
	}

	@Override
	public Colaborador findByNome(Integer tenantId, String nome)
	{
		return colaboradorRepository.findByNome(tenantId, nome);
	}

	@Override
	public List<Colaborador> findByTenantId(Integer tenantId)
	{
		return colaboradorRepository.findByTenant_id(tenantId);
	}

	@Override
	public List<Colaborador> findAll(Integer tenantId)
	{
		return null;
	}
}
