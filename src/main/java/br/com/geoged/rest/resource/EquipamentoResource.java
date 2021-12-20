package br.com.geoged.rest.resource;

import java.util.List;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.entity.Equipamento;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.EquipamentoService;


@RestController
@RequestMapping(value = "/equipamento")
public class EquipamentoResource
{
	@Autowired
	private EquipamentoService equipamentoService;
	@GetMapping(value = "/find_by_nome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response findByNome(@QueryParam("tenantId") Integer tenantId, @QueryParam("nome") String nome)
	{
		Response response;
		var tmp = equipamentoService.findByNome(tenantId, nome);
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

	@PostMapping(value = "/salvar")
	public Response salvar(@RequestBody Equipamento entity) throws GeoGedException
	{
		Response response;
		var tmp = equipamentoService.save(entity);
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

	@GetMapping(value = "/find_by_tenant_id")
	public Response findByTenantId(@QueryParam(value = "tenantId") Integer tenantId)
	{
		Response response;
		List<Equipamento> tmp = equipamentoService.findByTenantId(tenantId);
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
