package br.com.geoged.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.entity.EquipamentoGrupo;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.EquipamentoGrupoService;

@RestController
@RequestMapping(value = "/equipamento_grupo")
@RequiredArgsConstructor
public class EquipamentoGrupoConroller {

	private final EquipamentoGrupoService equipamentoGrupoService;

	@GetMapping(value = "/find_by_nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EquipamentoGrupo> findByNome( Integer tenantId,
			 String nome) {
		ResponseEntity<EquipamentoGrupo> response;
		EquipamentoGrupo tmp = equipamentoGrupoService.findByNome(tenantId, nome);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}

	@PostMapping(value = "/salvar")
	public ResponseEntity<EquipamentoGrupo> salvar(@RequestBody EquipamentoGrupo entity) throws GeoGedException {
		ResponseEntity<EquipamentoGrupo> response;
		EquipamentoGrupo tmp = equipamentoGrupoService.save(entity);
		if (tmp != null) {
			response = ResponseEntity.ok(tmp);
		} else {
			response = ResponseEntity.noContent().build();
		}
		return response;
	}
}
