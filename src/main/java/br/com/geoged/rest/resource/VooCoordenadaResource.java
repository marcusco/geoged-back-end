package br.com.geoged.rest.resource;

import java.util.List;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.dto.VooCordenadaAcaoMapaDTO;
import br.com.geoged.dto.VooCordenadaDTO;
import br.com.geoged.entity.VooCordenada;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.VooCordenadaService;


@RestController
@RequestMapping(value = "/voo_cordenada")
public class VooCoordenadaResource
{
	@Autowired
	private VooCordenadaService vooCordenadaService;
	//
	@GetMapping(value = "/find_by_tenant_id")
	public ResponseEntity<List<VooCordenada>> findByTenantId(@QueryParam(value = "tenantId") Integer tenantId)
	{
		ResponseEntity<List<VooCordenada>> response;
		var tmp = vooCordenadaService.findByTenantId(tenantId);
		if(tmp != null)
		{
			response = ResponseEntity.ok(tmp);
		}
		else
		{
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@GetMapping(value = "/find_mapa_dto_by_idvoo/{idVoo}")
	public ResponseEntity<List<VooCordenadaAcaoMapaDTO>> findByIdVoo(@PathVariable Integer idVoo)
	{
		ResponseEntity<List<VooCordenadaAcaoMapaDTO>> response;
		var tmp = vooCordenadaService.findVooCordenadaAcaoDTOByIdVoo(idVoo);
		if(tmp != null)
		{
			response = ResponseEntity.ok(tmp);
		}
		else
		{
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@PostMapping(value = "/save")
	public ResponseEntity<VooCordenadaDTO> salvar(@RequestBody VooCordenadaDTO entity) throws GeoGedException
	{
		ResponseEntity<VooCordenadaDTO> response;
		var tmp = vooCordenadaService.saveDTO(entity);
		if(tmp != null)
		{
			response = ResponseEntity.ok(tmp);
		}
		else
		{
			response = ResponseEntity.noContent().build();
		}
		return response;
	}
}
