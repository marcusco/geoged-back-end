package br.com.geoged.rest.resource;

import java.util.List;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.entity.Usuario;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.UsuarioService;


@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource
{
	@Autowired
	private UsuarioService usuarioService;
	//
	@GetMapping(value = "find_by_email")
	public ResponseEntity<List<Usuario>> findByEmail(@QueryParam(value = "email") String email)
	{
		ResponseEntity<List<Usuario>> response;
		var tmp = usuarioService.findByEmail(email);
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

	@GetMapping(value = "/find_by_tenant_id", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> findByTenantId(@QueryParam(value = "tenantId") Integer tenantId)
	{
		ResponseEntity<List<Usuario>> response;
		var tmp = usuarioService.findByTenantId(tenantId);
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

	@GetMapping(value = "/find_by_id")
	public ResponseEntity<Usuario> findById(@QueryParam(value = "id") Integer id)
	{
		ResponseEntity<Usuario> response;
		var tmp = usuarioService.findById(id).orElseThrow();
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
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario entity) throws GeoGedException
	{
		ResponseEntity<Usuario> response;
		var tmp = usuarioService.save(entity);
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

	@GetMapping(value = "/delete")
	public ResponseEntity<Usuario> deleteById(@PathVariable(value = "usuario") Usuario usuario) throws GeoGedException
	{
		usuarioService.delete(usuario);
		return ResponseEntity.ok().build();
	}
}
