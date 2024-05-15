package br.com.geoged.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.dto.VooDTO;
import br.com.geoged.entity.Voo;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.VooService;
import br.com.geoged.util.CollectionsUtil;

@RestController
@RequestMapping(value = "/voo")
@RequiredArgsConstructor
public class VooController {

	private final VooService vooService;

	//
	@GetMapping(value = "/find_by_tenant_id/{tenant_id}")
	public ResponseEntity<List<Voo>> findByTenantId(@PathVariable Integer tenant_id) {
		ResponseEntity<List<Voo>> response;
		List<Voo> tmp = vooService.findByTenantId(tenant_id);
		if (!CollectionsUtil.isEmpty(tmp)) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.notFound().build();
		}
		return response;
	}

	@GetMapping(value = "/count_by_tenant_id/{tenant_id}")
	public ResponseEntity<Integer> countByTenantId(@PathVariable Integer tenant_id) {
		ResponseEntity<Integer> response;
		Integer tmp = vooService.countByTenantI(tenant_id);
		if (tmp > 0) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.notFound().build();
		}
		return response;
	}

	@PostMapping(value = "/save_all")
	public ResponseEntity<List<VooDTO>> saveAll(@RequestBody List<VooDTO> entity) throws GeoGedException {
		ResponseEntity<List<VooDTO>> response;
		// nver name
		List<VooDTO> tmp = vooService.saveDTO(entity);
		if (!CollectionsUtil.isEmpty(tmp)) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@PostMapping(value = "/save")
	public ResponseEntity<VooDTO> save(@RequestBody VooDTO entity) throws GeoGedException {
		ResponseEntity<VooDTO> response;
		// nver name
		VooDTO tmp = vooService.saveDTO(entity);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}
}
