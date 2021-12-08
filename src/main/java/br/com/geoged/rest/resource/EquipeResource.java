package br.com.geoged.rest.resource;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.entity.Equipe;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.EquipeService;

@RestController
@RequestMapping(value = "/equipe")
public class EquipeResource {

  @Autowired
  private EquipeService equipeService;

  @GetMapping(value = "/find_by_nome", produces = MediaType.APPLICATION_JSON_VALUE)
  public Response findByNome(@QueryParam("tenantId") Integer tenantId,
      @QueryParam("nome") String nome) {
    Response response;
    var tmp = equipeService.findByNome(tenantId, nome);
    if (tmp != null) {
      response = Response.ok(tmp).build();
    } else {
      response = Response.noContent().build();
    }
    return response;
  }

  @PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
  public Response salvar(@RequestBody Equipe entity) throws GeoGedException {
    Response response;
    var tmp = equipeService.save(entity);
    if (tmp != null) {
      response = Response.ok(tmp).build();
    } else {
      response = Response.noContent().build();
    }
    return response;
  }


}
