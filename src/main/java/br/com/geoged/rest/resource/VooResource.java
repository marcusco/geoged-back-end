package br.com.geoged.rest.resource;

import java.util.List;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/voo")
public class VooResource
{
	@Autowired
	private VooService vooService;
	//
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

	@PostMapping(value = "/save_all")
	public ResponseEntity<List<Voo>> saveAll(@RequestBody List<Voo> entity) throws GeoGedException
	{
		ResponseEntity<List<Voo>> response;
		// nver name
		var tmp = vooService.save(entity);
		if(!CollectionsUtil.isEmpty(tmp))
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
	public ResponseEntity<Voo> save(@RequestBody Voo entity) throws GeoGedException
	{
		ResponseEntity<Voo> response;
		// nver name
		var tmp = vooService.save(entity);
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
