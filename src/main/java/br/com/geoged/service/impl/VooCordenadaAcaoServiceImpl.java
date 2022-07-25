package br.com.geoged.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.dto.VooCordenadaAcaoDTO;
import br.com.geoged.entity.AcaoTipo;
import br.com.geoged.entity.VooCordenada;
import br.com.geoged.entity.VooCordenadaAcao;
import br.com.geoged.repositoty.VooCordenadaAcaoRepository;
import br.com.geoged.service.VooCordenadaAcaoService;


@Service
public class VooCordenadaAcaoServiceImpl extends ServiceBaseImpl<VooCordenadaAcao> implements VooCordenadaAcaoService
{
	@Autowired
	private VooCordenadaAcaoRepository vooCordenadaAcaoRepository;
	@Override
	public VooCordenadaAcao save(VooCordenadaAcao entity)
	{
		return vooCordenadaAcaoRepository.save(entity);
	}

	public Optional<VooCordenadaAcao> findById(Integer id)
	{
		return vooCordenadaAcaoRepository.findById(id);
	}

	@Override
	public void delete(VooCordenadaAcao entity)
	{
		vooCordenadaAcaoRepository.delete(entity);
	}

	@Override
	public List<VooCordenadaAcao> findAll(Integer tenantId)
	{
		return vooCordenadaAcaoRepository.findAll();
	}

	@Override
	public List<VooCordenadaAcao> saveAll(List<VooCordenadaAcao> cordenadaAcoes)
	{
		List<VooCordenadaAcao> tmp = new ArrayList<>();
		for(VooCordenadaAcao acao : cordenadaAcoes)
		{
			tmp.add(save(acao));
		}
		return tmp;
	}

	@Override
	public List<VooCordenadaAcao> findByTenantId(Integer tenantId)
	{
		return null;
	}

	@Override
	public VooCordenadaAcaoDTO saveDTO(VooCordenadaAcaoDTO dto)
	{
		var tmp = vooCordenadaAcaoRepository.findByTenantIAndAIdVooCordenadaAndIdAcaoTipoAndDataRegistro(dto.getTenant_id(), dto.getIdVooCordenada(), dto.getIdAcaoTipo(), dto.getDataRegistro());
		if(tmp == null)
		{
			tmp = convertDtoToClassVooCordenadaAcao(dto);
			tmp = vooCordenadaAcaoRepository.save(tmp);
		}
		dto.setIdExterno(tmp.getId());
		dto.setValorBlob(null);
		return dto;
	}

	private VooCordenadaAcao convertDtoToClassVooCordenadaAcao(VooCordenadaAcaoDTO dto)
	{
		var acao = new VooCordenadaAcao();
		acao.setTenant_id(dto.getTenant_id());
		acao.setId(dto.getIdExterno() == 0 ? null : dto.getIdExterno());
		acao.setIdExterno(dto.getId());
		acao.setAcaoTipo(new AcaoTipo(dto.getIdAcaoTipo()));
		acao.setValorBlob(dto.getValorBlob());
		acao.setValorClob(dto.getValorClob());
		acao.setDataRegistro(dto.getDataRegistro());
		acao.setVooCordenada(new VooCordenada(dto.getIdVooCordenada()));
		return acao;
	}

	@Override
	public VooCordenadaAcao findByIdVooCordenadaAcao(Integer id)
	{
		return vooCordenadaAcaoRepository.findByIdVooCordenadaAcao(id);
	}
	

	@Override
	public Integer countByTenantId(Integer tenantId)
	{
		return vooCordenadaAcaoRepository.countByTenantId(tenantId);
	}
}
