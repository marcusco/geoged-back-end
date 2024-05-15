package br.com.geoged.service;

import java.util.List;
import org.springframework.data.repository.query.Param;
import br.com.geoged.dto.VooCordenadaAcaoDTO;
import br.com.geoged.entity.VooCordenadaAcao;


public interface VooCordenadaAcaoService extends IServiceBase<VooCordenadaAcao>
{
	public List<VooCordenadaAcao> saveAll(List<VooCordenadaAcao> cordenadaAcoes);

	public List<VooCordenadaAcao> findByTenantId(Integer tenantId);

	public VooCordenadaAcaoDTO saveDTO(VooCordenadaAcaoDTO dto);
	
	public VooCordenadaAcao findByIdVooCordenadaAcao(Integer id);
	
	public Integer countByTenantId(Integer tenantId);
	
}
