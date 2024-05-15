package br.com.geoged.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.geoged.dto.VooCordenadaAcaoDTO;
import br.com.geoged.entity.VooCordenadaAcao;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.VooCordenadaAcaoService;

import java.util.List;

@RestController
@RequestMapping(value = "/voo_cordenada_acao")
@RequiredArgsConstructor
public class VooCoordenadaAcaoController {

	private final VooCordenadaAcaoService vooCordenadaAcaoService;
	//
	@GetMapping(value = "/find_by_tenant_id")
	public List<VooCordenadaAcao> findByTenantId(Integer tenantId) {
		return vooCordenadaAcaoService.findByTenantId(tenantId);

	}

	@PostMapping(value = "/save")
	public ResponseEntity<VooCordenadaAcaoDTO> salvar(String json,
			@RequestPart("file") MultipartFile file)
			throws GeoGedException, JsonMappingException, JsonProcessingException {
		ResponseEntity<VooCordenadaAcaoDTO> response;
		ObjectMapper objectMapper = new ObjectMapper();
		VooCordenadaAcaoDTO entity = objectMapper.readValue(json, VooCordenadaAcaoDTO.class);
		try {
			entity.setValorBlob(file.getBytes());
			VooCordenadaAcaoDTO tmp = vooCordenadaAcaoService.saveDTO(entity);
			if (tmp != null) {
				response = ResponseEntity.ok(tmp);
			} else {
				response = ResponseEntity.noContent().build();
			}
		} catch (Exception e) {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@GetMapping(value = "/find_by_idvoocordenadaacao/{idVooCordenadaAcao}")
	public ResponseEntity<VooCordenadaAcao> findByIdVooCordenadaAcao(@PathVariable Integer idVooCordenadaAcao) {
		ResponseEntity<VooCordenadaAcao> response;
		VooCordenadaAcao tmp = vooCordenadaAcaoService.findByIdVooCordenadaAcao(idVooCordenadaAcao);
		if (tmp != null) {
			tmp.setAcaoTipo(null);
			tmp.setVooCordenada(null);
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@GetMapping(value = "/count_by_tenant_id/{tenant_id}")
	public ResponseEntity<Integer> countByTenantId(@PathVariable Integer tenant_id) {
		ResponseEntity<Integer> response;
		Integer tmp = vooCordenadaAcaoService.countByTenantId(tenant_id);
		if (tmp > 0) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.notFound().build();
		}
		return response;
	}

}
