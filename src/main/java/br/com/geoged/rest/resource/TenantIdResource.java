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
import br.com.geoged.entity.TenantId;
import br.com.geoged.service.TenantIdService;


@RestController
@RequestMapping(value = "/tenant_id")
public class TenantIdResource
{
	@Autowired
	private TenantIdService tenantIdService;
	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TenantId> save(@RequestBody TenantId entity)
	{
		try
		{
			var tmp = tenantIdService.save(entity);
			if(tmp != null)
			{
				return ResponseEntity.ok().body(tmp);
			}
			else
			{
				return ResponseEntity.badRequest().build();
			}
		}
		catch (Exception e)
		{
			ResponseEntity.badRequest();
		}
		return null;
	}

	@GetMapping(value = "/find_by_id")
	public ResponseEntity<TenantId> findById(@QueryParam(value = "id") Integer id)
	{
		var tmp = tenantIdService.findByTenantId(id);
		if(tmp != null)
		{
			return ResponseEntity.ok().body(tmp);
		}
		else
		{
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping(value = "/find_all")
	public ResponseEntity<List<TenantId>> findAll()
	{
		List<TenantId> tmp = tenantIdService.findByAll();
		if(tmp != null)
		{
			return ResponseEntity.ok().body(tmp);
		}
		else
		{
			return ResponseEntity.badRequest().build();
		}
	}
}
