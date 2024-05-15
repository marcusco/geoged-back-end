package br.com.geoged.service.impl;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.Equipe;
import br.com.geoged.repositoty.EquipeRepository;
import br.com.geoged.service.EquipeService;


@Service
@RequiredArgsConstructor
public class EquipeServiceImpl extends ServiceBaseImpl<Equipe> implements EquipeService
{
	private final EquipeRepository equipeRepository;
	@Override
	public Equipe save(Equipe entity)
	{
		return equipeRepository.save(entity);
	}

	public Optional<Equipe> findById(Integer id)
	{
		return equipeRepository.findById(id);
	}

	@Override
	public void delete(Equipe entity)
	{
		equipeRepository.delete(entity);
	}

	@Override
	public List<Equipe> findByTenantId(Integer tenantId)
	{
		return equipeRepository.findByTenantId(tenantId);
	}

	@Override
	public Equipe findByNome(Integer tenantId, String nome)
	{
		return equipeRepository.findByNome(tenantId, nome);
	}

	@Override
	public List<Equipe> findAll(Integer tenantId)
	{
		return null;
	}
}
