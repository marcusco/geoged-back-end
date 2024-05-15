package br.com.geoged.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequiredArgsConstructor
public class TenantIdConroller {

	private final TenantIdService tenantIdService;

	@PostMapping(value = "/salvar")
	public ResponseEntity<TenantId> save(@RequestBody TenantId entity) {
		try {
			TenantId tmp = tenantIdService.save(entity);
			if (tmp != null) {
				return ResponseEntity.ok().body(tmp);
			} else {
				return ResponseEntity.badRequest().build();
			}
		} catch (Exception e) {
			ResponseEntity.badRequest();
		}
		return null;
	}

	@GetMapping(value = "/find_by_id")
	public ResponseEntity<TenantId> findById(Integer id) {
		TenantId tmp = tenantIdService.findByTenantId(id);
		if (tmp != null) {
			return ResponseEntity.ok().body(tmp);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping(value = "/find_all")
	public ResponseEntity<List<TenantId>> findAll() {
		List<TenantId> tmp = tenantIdService.findByAll();
		if (tmp != null) {
			return ResponseEntity.ok().body(tmp);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
