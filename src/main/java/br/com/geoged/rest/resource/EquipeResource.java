package br.com.geoged.rest.resource;

import java.util.List;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.entity.Equipe;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.EquipeService;


@RestController
@RequestMapping(value = "/equipe")
public class EquipeResource
{
	@Autowired
	private EquipeService equipeService;
	@GetMapping(value = "/find_by_nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Equipe> findByNome(@QueryParam("tenantId") Integer tenantId, @QueryParam("nome") String nome)
	{
		ResponseEntity<Equipe> response;
		var tmp = equipeService.findByNome(tenantId, nome);
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

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Equipe> salvar(@RequestBody Equipe entity) throws GeoGedException
	{
		ResponseEntity<Equipe> response;
		var tmp = equipeService.save(entity);
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

	@GetMapping(value = "/find_by_tenant_id")
	public ResponseEntity<List<Equipe>> findByTenantId(@QueryParam(value = "tenantId") Integer tenantId)
	{
		ResponseEntity<List<Equipe>> response;
		List<Equipe> tmp = equipeService.findByTenantId(tenantId);
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
