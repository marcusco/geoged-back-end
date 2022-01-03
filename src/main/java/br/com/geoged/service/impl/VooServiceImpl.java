package br.com.geoged.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.Voo;
import br.com.geoged.entity.VooCordenada;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.repositoty.VooRepository;
import br.com.geoged.service.VooCordenadaService;
import br.com.geoged.service.VooService;
import br.com.geoged.util.CollectionsUtil;


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
		return vooRepository.findBytenant_id(tenantId).orElseThrow(() -> new GeoGedException("sem.dados"));
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

	@Override
	public List<Voo> save(List<Voo> list)
	{
		List<Voo> result = new ArrayList<>();
		//
		if(!CollectionsUtil.isEmpty(list))
		{
			for(Voo voo : list)
			{
				try
				{
					Voo tmp = findByTenantIAndDescricaoAndNomeAndDataRegistro(voo.getTenant_id(), voo.getDescricao(), voo.getNome(), voo.getDataRegistro());
					if(tmp == null)
					{
						tmp = vooRepository.save(voo);
					}
					voo.setId(tmp.getId());
					voo.setIdExterno(tmp.getId());
					result.add(voo);
					if(!CollectionsUtil.isEmpty(voo.getCordenadas()))
					{
						saveCordenada(voo);
					}
				}
				catch (Exception e)
				{
				}
			}
		}
		return result;
	}

	public Voo findByTenantIAndDescricaoAndNomeAndDataRegistro(Integer tenantId, String descricao, String nome, Calendar dataRegistro)
	{
		return vooRepository.findByTenantIAndDescricaoAndNomeAndDataRegistro(tenantId, descricao, nome, dataRegistro);
	}

	private Voo saveCordenada(Voo voo)
	{
		List<VooCordenada> result = new ArrayList<>();
		//
		for(VooCordenada cordenada : voo.getCordenadas())
		{
			cordenada.setVoo(voo);
			var tmp = vooCordenadaService.save(cordenada);
			tmp.setIdExterno(tmp.getId());
			result.add(tmp);
		}
		voo.setCordenadas(result);
		return voo;
	}
}
