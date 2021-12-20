package br.com.geoged.rest.resource;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.entity.Colaborador;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.ColaboradorService;


@RestController
@RequestMapping(value = "/colaborador", produces = MediaType.APPLICATION_JSON_VALUE)
public class ColaboradorResource
{
	@Autowired
	private ColaboradorService colaboradorService;
	@GetMapping(value = "/find_by_nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Colaborador> findByNome(@PathParam(value = "tenantId") Integer tenantId, @PathParam(value = "nome") String nome)
	{
		ResponseEntity<Colaborador> response;
		var tmp = colaboradorService.findByNome(tenantId, nome);
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

	@PostMapping(value = "/salvar")
	public ResponseEntity<Colaborador> salvar(@RequestBody Colaborador entity) throws GeoGedException
	{
		ResponseEntity<Colaborador> response;
		var tmp = colaboradorService.save(entity);
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
	public ResponseEntity<List<Colaborador>> findByTenantId(@QueryParam(value = "tenantId") Integer tenantId)
	{
		ResponseEntity<List<Colaborador>> response;
		List<Colaborador> tmp = colaboradorService.findByTenantId(tenantId);
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
