package br.com.geoged.service;

import java.util.List;
import br.com.geoged.dto.VooDTO;
import br.com.geoged.entity.Voo;


public interface VooService extends IServiceBase<Voo>
{
	public Voo findByNome(Integer tenantId, String nome);

	public Voo findByDescricao(Integer tenantId, String descricao);

	public List<Voo> findByTenantId(Integer tenantId);

	public List<VooDTO> saveDTO(List<VooDTO> dtos);

	public VooDTO saveDTO(VooDTO dto);
}
