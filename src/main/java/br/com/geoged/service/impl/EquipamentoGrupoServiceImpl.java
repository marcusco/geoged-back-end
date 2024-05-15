package br.com.geoged.service.impl;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.EquipamentoGrupo;
import br.com.geoged.repositoty.EquipamentoGrupoRepository;
import br.com.geoged.service.EquipamentoGrupoService;


@Service
@RequiredArgsConstructor
public class EquipamentoGrupoServiceImpl extends ServiceBaseImpl<EquipamentoGrupo> implements EquipamentoGrupoService
{

	private final EquipamentoGrupoRepository equipamentoGrupoRepository;
	@Override
	public EquipamentoGrupo save(EquipamentoGrupo entity)
	{
		return equipamentoGrupoRepository.save(entity);
	}

	public Optional<EquipamentoGrupo> findById(Integer id)
	{
		return equipamentoGrupoRepository.findById(id);
	}

	@Override
	public void delete(EquipamentoGrupo entity)
	{
		equipamentoGrupoRepository.delete(entity);
	}

	@Override
	public List<EquipamentoGrupo> findByTenantId(Integer tenantId)
	{
		return equipamentoGrupoRepository.findTenant_id(tenantId);
	}

	@Override
	public EquipamentoGrupo findByNome(Integer tenantId, String nome)
	{
		return equipamentoGrupoRepository.findByNome(tenantId, nome);
	}

	@Override
	public List<EquipamentoGrupo> findAll(Integer tenantId)
	{
		return null;
	}
}
