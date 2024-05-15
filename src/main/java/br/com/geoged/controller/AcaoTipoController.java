package br.com.geoged.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.entity.AcaoTipo;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.AcaoTipoService;
import br.com.geoged.util.CollectionsUtil;

@RestController
@RequestMapping(value = "/acao_tipo")
@RequiredArgsConstructor
public class AcaoTipoController {
	private final AcaoTipoService acaoTipoService;
	//
	@GetMapping(value = "/find_by_tenant_id")
	public ResponseEntity<List<AcaoTipo>> findByTenantId(Integer tenantId) {
		ResponseEntity<List<AcaoTipo>> response;
		List<AcaoTipo> tmp = acaoTipoService.findByTenantId(tenantId);
		if (!CollectionsUtil.isEmpty(tmp)) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.notFound().build();
		}
		return response;
	}

	@GetMapping(value = "/find_by_id")
	public AcaoTipo findById(Integer tenantId) {
		return acaoTipoService.findById(tenantId).orElseThrow(null);
	}

	@PostMapping(value = "/salvar")
	public ResponseEntity<AcaoTipo> salvar(@RequestBody AcaoTipo entity) throws GeoGedException {
		ResponseEntity<AcaoTipo> response;
		AcaoTipo tmp = acaoTipoService.save(entity);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<AcaoTipo> delete(@RequestBody AcaoTipo entity) throws GeoGedException {
		ResponseEntity<AcaoTipo> response;
		acaoTipoService.delete(entity);
		response = ResponseEntity.ok().build();
		return response;
	}
}
