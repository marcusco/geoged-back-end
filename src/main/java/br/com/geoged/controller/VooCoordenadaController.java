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
import br.com.geoged.dto.VooCordenadaAcaoMapaDTO;
import br.com.geoged.dto.VooCordenadaDTO;
import br.com.geoged.entity.VooCordenada;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.VooCordenadaService;

@RestController
@RequestMapping(value = "/voo_cordenada")
@RequiredArgsConstructor
public class VooCoordenadaController {

	private final VooCordenadaService vooCordenadaService;

	//
	@GetMapping(value = "/find_by_tenant_id")
	public ResponseEntity<List<VooCordenada>> findByTenantId(Integer tenantId) {
		ResponseEntity<List<VooCordenada>> response;
		List<VooCordenada> tmp = vooCordenadaService.findByTenantId(tenantId);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@GetMapping(value = "/find_mapa_dto_by_idvoo/{idVoo}")
	public ResponseEntity<List<VooCordenadaAcaoMapaDTO>> findByIdVoo(@PathVariable Integer idVoo) {
		ResponseEntity<List<VooCordenadaAcaoMapaDTO>> response;
		List<VooCordenadaAcaoMapaDTO> tmp = vooCordenadaService.findVooCordenadaAcaoDTOByIdVoo(idVoo);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@PostMapping(value = "/save")
	public ResponseEntity<VooCordenadaDTO> salvar(@RequestBody VooCordenadaDTO entity) throws GeoGedException {
		ResponseEntity<VooCordenadaDTO> response;
		VooCordenadaDTO tmp = vooCordenadaService.saveDTO(entity);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@GetMapping(value = "/count_by_tenant_id/{tenant_id}")
	public ResponseEntity<Integer> countByTenantId(@PathVariable Integer tenant_id) {
		ResponseEntity<Integer> response;
		Integer tmp = vooCordenadaService.countByTenantId(tenant_id);
		if (tmp > 0) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.notFound().build();
		}
		return response;
	}

}
