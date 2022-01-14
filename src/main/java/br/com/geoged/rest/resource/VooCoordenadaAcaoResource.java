package br.com.geoged.rest.resource;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.geoged.dto.VooCordenadaAcaoDTO;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.VooCordenadaAcaoService;


@RestController
@RequestMapping(value = "/voo_cordenada_acao", produces = MediaType.APPLICATION_JSON_VALUE)
public class VooCoordenadaAcaoResource
{
	@Autowired
	private VooCordenadaAcaoService vooCordenadaAcaoService;
	//
	@GetMapping(value = "/find_by_tenant_id")
	public Response findByTenantId(@QueryParam(value = "tenantId") Integer tenantId)
	{
		Response response;
		var tmp = vooCordenadaAcaoService.findByTenantId(tenantId);
		if(tmp != null)
		{
			response = Response.ok(tmp).build();
		}
		else
		{
			response = Response.noContent().build();
		}
		return response;
	}

	@PostMapping(value = "/save")
	public ResponseEntity<VooCordenadaAcaoDTO> salvar(@QueryParam("json") String json, @RequestPart("file") MultipartFile file) throws GeoGedException, JsonMappingException, JsonProcessingException
	{
		ResponseEntity<VooCordenadaAcaoDTO> response;
		var objectMapper = new ObjectMapper();
		VooCordenadaAcaoDTO entity = objectMapper.readValue(json, VooCordenadaAcaoDTO.class);
		try
		{
			entity.setValorBlob(file.getBytes());
			var tmp = vooCordenadaAcaoService.saveDTO(entity);
			if(tmp != null)
			{
				response = ResponseEntity.ok(tmp);
			}
			else
			{
				response = ResponseEntity.noContent().build();
			}
		}
		catch (Exception e)
		{
			response = ResponseEntity.noContent().build();
		}
		return response;
	}
}
