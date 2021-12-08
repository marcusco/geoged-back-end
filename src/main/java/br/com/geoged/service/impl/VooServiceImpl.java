package br.com.geoged.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.Voo;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.repositoty.VooRepository;
import br.com.geoged.service.VooCordenadaService;
import br.com.geoged.service.VooService;


@Service
public class VooServiceImpl extends ServiceBaseImpl<Voo> implements VooService
{
	@Autowired
	private VooRepository			vooRepository;
	@Autowired
	private VooCordenadaService	vooCordenadaService;
	@Override
	public Voo save(Voo entity) throws GeoGedException
	{
		Voo tmp = null;
		if(entity != null)
		{
			vooCordenadaService.saveAll(entity.getCordenadas());
			tmp = vooRepository.save(entity);
		}
		return tmp;
	}

	public Optional<Voo> findById(Integer id)
	{
		return Optional.of(vooRepository.findById(id).orElseThrow(() -> new GeoGedException("sem.dados")));
	}

	@Override
	public void delete(Voo entity)
	{
		vooRepository.delete(entity);
	}

	@Override
	public List<Voo> findByTenantId(Integer tenantId)
	{
		return vooRepository.findByTenantId(tenantId).orElseThrow(() -> new GeoGedException("sem.dados"));
	}

	@Override
	public Voo findByNome(Integer tenantId, String nome)
	{
		return vooRepository.findByNome(tenantId, nome);
	}

	@Override
	public Voo findByDescricao(Integer tenantId, String descricao)
	{
		return vooRepository.findByDescricao(tenantId, descricao);
	}

	@Override
	public List<Voo> findAll(Integer tenantId)
	{
		return null;
	}
}
