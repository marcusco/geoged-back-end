package br.com.geoged.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.dto.VooCordenadaAcaoMapaDTO;
import br.com.geoged.dto.VooCordenadaDTO;
import br.com.geoged.entity.Voo;
import br.com.geoged.entity.VooCordenada;
import br.com.geoged.entity.VooCordenadaAcao;
import br.com.geoged.repositoty.VooCordenadaRepository;
import br.com.geoged.service.VooCordenadaAcaoService;
import br.com.geoged.service.VooCordenadaService;


@Service
public class VooCordenadaServiceImpl extends ServiceBaseImpl<VooCordenada> implements VooCordenadaService
{
	@Autowired
	private VooCordenadaRepository	vooCordenadaRepository;
	@Autowired
	private VooCordenadaAcaoService	vooCordenadaAcaoService;
	@Override
	public VooCordenada save(VooCordenada entity)
	{
		List<VooCordenadaAcao> tmp = new ArrayList<>();
		tmp.addAll(vooCordenadaAcaoService.saveAll(entity.getAcoes()));
		entity.setAcoes(tmp);
		return vooCordenadaRepository.save(entity);
	}

	public Optional<VooCordenada> findById(Integer id)
	{
		return vooCordenadaRepository.findById(id);
	}

	@Override
	public void delete(VooCordenada entity)
	{
		vooCordenadaRepository.delete(entity);
	}

	@Override
	public List<VooCordenada> findAll(Integer tenantId)
	{
		return vooCordenadaRepository.findAll();
	}

	@Override
	public List<VooCordenada> saveAll(List<VooCordenada> cordenadas)
	{
		List<VooCordenada> tmp = new ArrayList<>();
		for(VooCordenada cordenada : cordenadas)
		{
			tmp.add(save(cordenada));
		}
		return tmp;
	}

	@Override
	public List<VooCordenada> findByTenantId(Integer tenantId)
	{
		return null;
	}

	@Override
	public VooCordenada findByTenantIAndAndIdVooAndDataRegistroAndLatitudeAndLongitudeAndAltitude(Integer tenant_id, Integer idVoo, Calendar dataRegistro, Double latitude, Double longitude, Double altitude)
	{
		return vooCordenadaRepository.findByTenantIAndAndIdVooAndDataRegistroAndLatitudeAndLongitudeAndAltitude(tenant_id, idVoo, dataRegistro, latitude, longitude, altitude);
	}

	@Override
	public VooCordenadaDTO saveDTO(VooCordenadaDTO dto)
	{
		var tmp = vooCordenadaRepository.findByTenantIAndAndIdVooAndDataRegistro(dto.getTenant_id(), dto.getIdVoo(), dto.getDataRegistro());
		if(tmp == null)
		{
			tmp = convertDtoToClassVooCordenada(dto);
			tmp = vooCordenadaRepository.save(tmp);
		}
		dto.setIdExterno(tmp.getId());
		return dto;
	}

	private VooCordenada convertDtoToClassVooCordenada(VooCordenadaDTO dto)
	{
		var cordenada = new VooCordenada();
		cordenada.setTenant_id(dto.getTenant_id());
		cordenada.setId(dto.getIdExterno() == 0 ? null : dto.getIdExterno());
		cordenada.setIdExterno(dto.getId());
		cordenada.setLatitude(dto.getLatitude());
		cordenada.setLongitude(dto.getLongitude());
		cordenada.setAltitude(dto.getAltitude());
		cordenada.setDataRegistro(dto.getDataRegistro());
		cordenada.setVoo(new Voo(dto.getIdVoo()));
		return cordenada;
	}

	@Override
	public List<VooCordenadaAcaoMapaDTO> findVooCordenadaAcaoDTOByIdVoo(Integer idVoo)
	{
		return vooCordenadaRepository.findVooCordenadaAcaoDTOByIdVoo(idVoo);
	}
}