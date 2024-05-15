package br.com.geoged.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
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
@RequestMapping(value = "/colaborador/")
@RequiredArgsConstructor
public class ColaboradorController {

	private final ColaboradorService colaboradorService;

	@GetMapping("find_by_nome/{tenant_id}/{nome}")
	public Colaborador findByNome(Integer tenantId, String nome) {
		return colaboradorService.findByNome(tenantId, nome);
	}

	@PostMapping(value = "salvar")
	public ResponseEntity<Colaborador> salvar(@RequestBody Colaborador entity) throws GeoGedException {
		ResponseEntity<Colaborador> response;
		Colaborador tmp = colaboradorService.save(entity);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@GetMapping(value = "/find_by_tenant_id")
	public ResponseEntity<List<Colaborador>> findByTenantId( Integer tenantId) {
		ResponseEntity<List<Colaborador>> response;
		List<Colaborador> tmp = colaboradorService.findByTenantId(tenantId);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}
}
