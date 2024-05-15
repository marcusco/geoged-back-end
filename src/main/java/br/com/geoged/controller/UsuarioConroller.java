package br.com.geoged.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class UsuarioConroller {

	private final UsuarioService usuarioService;

	//
	@GetMapping(value = "find_by_email")
	public ResponseEntity<List<Usuario>> findByEmail(String email) {
		ResponseEntity<List<Usuario>> response;
		List<Usuario> tmp = usuarioService.findByEmail(email);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@GetMapping(value = "/find_by_tenant_id")
	public ResponseEntity<List<Usuario>> findByTenantId(Integer tenantId) {
		ResponseEntity<List<Usuario>> response;
		if (tenantId < 0) {
			return ResponseEntity.badRequest().build();
		}
		List<Usuario> tmp = usuarioService.findByTenantId(tenantId);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@GetMapping(value = "/find_by_id")
	public ResponseEntity<Usuario> findById( Integer id) {
		ResponseEntity<Usuario> response;
		Usuario tmp = usuarioService.findById(id).orElseThrow(null);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario entity) throws GeoGedException {
		ResponseEntity<Usuario> response;
		Usuario tmp = usuarioService.save(entity);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@GetMapping(value = "/delete")
	public ResponseEntity<Usuario> deleteById(@PathVariable(value = "usuario") Usuario usuario) throws GeoGedException {
		usuarioService.delete(usuario);
		return ResponseEntity.ok().build();
	}
}
