package br.com.geoged.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.dto.VooCordenadaAcaoDTO;
import br.com.geoged.dto.VooCordenadaDTO;
import br.com.geoged.dto.VooDTO;
import br.com.geoged.entity.AcaoTipo;
import br.com.geoged.entity.Equipamento;
import br.com.geoged.entity.Equipe;
import br.com.geoged.entity.Usuario;
import br.com.geoged.entity.Voo;
import br.com.geoged.entity.VooCordenada;
import br.com.geoged.entity.VooCordenadaAcao;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.repositoty.VooRepository;
import br.com.geoged.service.VooCordenadaAcaoService;
import br.com.geoged.service.VooCordenadaService;
import br.com.geoged.service.VooService;
import br.com.geoged.util.CollectionsUtil;


@Service
public class VooServiceImpl extends ServiceBaseImpl<Voo> implements VooService
{
	@Autowired
	private VooRepository				vooRepository;
	@Autowired
	private VooCordenadaService		vooCordenadaService;
	@Autowired
	private VooCordenadaAcaoService	vooCordenadaAcaoService;
	//
	public VooServiceImpl()
	{
		super();
	}

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

	@Override
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

	public Voo findByTenantIAndDescricaoAndNomeAndDataRegistro(Integer tenantId, String descricao, String nome, Calendar dataRegistro)
	{
		return vooRepository.findByTenantIAndDescricaoAndNomeAndDataRegistro(tenantId, descricao, nome, dataRegistro);
	}

	public List<VooDTO> saveDTO(List<VooDTO> dtos)
	{
		//
		List<VooDTO> result = new ArrayList<>();
		//
		if(!CollectionsUtil.isEmpty(dtos))
		{
			for(VooDTO dto : dtos)
			{
				try
				{
					//
					var voo = convertDtoToClassVoo(dto);
					//
					if(voo.getId() == null)
					{
						var tmp = vooRepository.save(voo);
						voo.setId(tmp.getId());
						dto.setIdExterno(tmp.getId());
					}
					if(!CollectionsUtil.isEmpty(dto.getCordenadas()))
					{
						dto.setCordenadas(saveCordenada(dto, voo));
					}
					//
					result.add(dto);
				}
				catch (Exception e)
				{
				}
			}
		}
		return result;
	}

	private List<VooCordenadaDTO> saveCordenada(VooDTO vooDTO, Voo voo)
	{
		List<VooCordenadaDTO> result = new ArrayList<>();
		//
		for(VooCordenadaDTO dto : vooDTO.getCordenadas())
		{
			var cordenada = convertDtoToClassVooCordenada(dto);
			//
			if(cordenada.getId() == null)
			{
				cordenada.setVoo(new Voo(voo.getId()));
				var tmp = vooCordenadaService.save(cordenada);
				cordenada.setId(tmp.getId());
				dto.setIdExterno(tmp.getId());
			}
			//
			if(!CollectionsUtil.isEmpty(dto.getAcoes()))
			{
				dto.setAcoes(saveCordenadaAcao(dto, cordenada));
			}
			result.add(dto);
		}
		return result;
	}

	private List<VooCordenadaAcaoDTO> saveCordenadaAcao(VooCordenadaDTO vooCordenada, VooCordenada cordenada)
	{
		List<VooCordenadaAcaoDTO> result = new ArrayList<>();
		//
		for(VooCordenadaAcaoDTO dto : vooCordenada.getAcoes())
		{
			var acao = convertDtoToClassVooCordenadaAcao(dto);
			//
			if(acao.getIdExterno() == null)
			{
				acao.setVooCordenada(new VooCordenada(cordenada.getId()));
				var tmp = vooCordenadaAcaoService.save(acao);
				dto.setIdExterno(tmp.getId());
			}
			result.add(dto);
		}
		return result;
	}

	private Voo convertDtoToClassVoo(VooDTO dto)
	{
		var voo = new Voo();
		voo.setTenant_id(dto.getTenant_id());
		voo.setId(dto.getIdExterno() == 0 ? null : dto.getIdExterno());
		voo.setIdExterno(dto.getId());
		voo.setNome(dto.getNome());
		voo.setDescricao(dto.getDescricao());
		voo.setDataRegistro(dto.getDataRegistro());
		voo.setEquipamento(new Equipamento(dto.getIdEquipamento()));
		voo.setEquipe(new Equipe(dto.getIdEquipe()));
		voo.setUsuario(new Usuario(dto.getIdUsuario()));
		return voo;
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
		return cordenada;
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
		return acao;
	}

	@Override
	public VooDTO saveDTO(VooDTO dto)
	{
		var tmp = vooRepository.findByTenantIAndNomeAndDataRegistro(dto.getTenant_id(), dto.getNome(), dto.getDataRegistro());
		if(tmp == null)
		{
			tmp = convertDtoToClassVoo(dto);
			tmp = vooRepository.save(tmp);
		}
		dto.setIdExterno(tmp.getId());
		return dto;
	}
}
