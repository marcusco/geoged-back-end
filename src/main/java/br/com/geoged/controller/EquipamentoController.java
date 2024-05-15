package br.com.geoged.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
@RequiredArgsConstructor
public class EquipamentoController {

	private final EquipamentoService equipamentoService;

	@GetMapping(value = "/find_by_nome/{nome}")
	public ResponseEntity<Equipamento> findByNome(Integer tenantId,
			String nome) {
		ResponseEntity<Equipamento> response;
		Equipamento tmp = equipamentoService.findByNome(tenantId, nome);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@PostMapping(value = "/salvar")
	public Equipamento salvar(@RequestBody Equipamento entity) throws GeoGedException {

		return equipamentoService.save(entity);
	}

	@GetMapping(value = "/find_by_tenant_id")
	public List<Equipamento> findByTenantId(Integer tenantId) {

		return equipamentoService.findByTenantId(tenantId);

	}
}
