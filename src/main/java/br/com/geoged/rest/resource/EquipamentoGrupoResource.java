package br.com.geoged.rest.resource;

import javax.ws.rs.QueryParam;
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
public class EquipamentoGrupoResource
{
	@Autowired
	private EquipamentoGrupoService equipamentoGrupoService;
	@GetMapping(value = "/find_by_nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EquipamentoGrupo> findByNome(@QueryParam("tenantId") Integer tenantId, @QueryParam("nome") String nome)
	{
		ResponseEntity<EquipamentoGrupo> response;
		var tmp = equipamentoGrupoService.findByNome(tenantId, nome);
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

	@PostMapping(value = "/salvar")
	public ResponseEntity<EquipamentoGrupo> salvar(@RequestBody EquipamentoGrupo entity) throws GeoGedException
	{
		ResponseEntity<EquipamentoGrupo> response;
		var tmp = equipamentoGrupoService.save(entity);
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
}
