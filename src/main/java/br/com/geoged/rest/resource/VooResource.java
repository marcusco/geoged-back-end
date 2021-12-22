package br.com.geoged.rest.resource;

import java.util.List;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.entity.Voo;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.VooService;
import br.com.geoged.util.CollectionsUtil;


@RestController
@RequestMapping(value = "/voo", produces = MediaType.APPLICATION_JSON_VALUE)
public class VooResource
{
	@Autowired
	private VooService vooService;
	@GetMapping(value = "/find_by_tenant_id")
	public ResponseEntity<List<Voo>> findByTenantId(@QueryParam(value = "tenantId") Integer tenantId)
	{
		ResponseEntity<List<Voo>> response;
		var tmp = vooService.findByTenantId(tenantId);
		if(!CollectionsUtil.isEmpty(tmp))
		{
			response = ResponseEntity.ok(tmp);
		}
		else
		{
			response = ResponseEntity.notFound().build();
		}
		return response;
	}

	@PostMapping(value = "/salvar")
	public Response salvar(@RequestBody Voo entity) throws GeoGedException
	{
		Response response;
		var tmp = vooService.save(entity);
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
}
