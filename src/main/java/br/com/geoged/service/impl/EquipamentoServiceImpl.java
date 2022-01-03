package br.com.geoged.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.Equipamento;
import br.com.geoged.repositoty.EquipamentoRepository;
import br.com.geoged.service.EquipamentoService;


@Service
public class EquipamentoServiceImpl extends ServiceBaseImpl<Equipamento> implements EquipamentoService
{
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	@Override
	public Equipamento save(Equipamento entity)
	{
		return equipamentoRepository.save(entity);
	}

	public Optional<Equipamento> findById(Integer id)
	{
		return equipamentoRepository.findById(id);
	}

	@Override
	public void delete(Equipamento entity)
	{
		equipamentoRepository.delete(entity);
	}

	@Override
	public List<Equipamento> findByTenantId(Integer tenantId)
	{
		return equipamentoRepository.findTenant_id(tenantId);
	}

	@Override
	public Equipamento findByNome(Integer tenantId, String nome)
	{
		return equipamentoRepository.findByNome(tenantId, nome);
	}

	@Override
	public List<Equipamento> findAll(Integer tenantId)
	{
		return null;
	}
}
