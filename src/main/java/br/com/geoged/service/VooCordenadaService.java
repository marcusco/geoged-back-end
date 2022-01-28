package br.com.geoged.service;

import java.util.Calendar;
import java.util.List;
import br.com.geoged.dto.VooCordenadaAcaoMapaDTO;
import br.com.geoged.dto.VooCordenadaDTO;
import br.com.geoged.entity.VooCordenada;


public interface VooCordenadaService extends IServiceBase<VooCordenada>
{
	public List<VooCordenada> saveAll(List<VooCordenada> cordenadas);

	public List<VooCordenada> findByTenantId(Integer tenantId);

	public VooCordenada findByTenantIAndAndIdVooAndDataRegistroAndLatitudeAndLongitudeAndAltitude(Integer tenant_id, Integer idVoo, Calendar dataRegistro, Double latitude, Double longitude, Double altitude);

	public VooCordenadaDTO saveDTO(VooCordenadaDTO dto);
	
	public List<VooCordenadaAcaoMapaDTO>findVooCordenadaAcaoDTOByIdVoo(Integer idVoo);
}
