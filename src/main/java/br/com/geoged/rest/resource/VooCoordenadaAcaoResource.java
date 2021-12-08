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
import br.com.geoged.entity.VooCordenadaAcao;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.VooCordenadaAcaoService;

@RestController
@RequestMapping(value = "/voo_cordenada_acao", produces = MediaType.APPLICATION_JSON_VALUE)
public class VooCoordenadaAcaoResource {

  @Autowired
  private VooCordenadaAcaoService vooCordenadaAcaoService;

  @GetMapping(value = "/find_by_tenant_id")
  public Response findByTenantId(@QueryParam(value = "tenantId") Integer tenantId) {
    Response response;
    var tmp = vooCordenadaAcaoService.findByTenantId(tenantId);
    if (tmp != null) {
      response = Response.ok(tmp).build();
    } else {
      response = Response.noContent().build();
    }
    return response;
  }

  @PostMapping(value = "/salvar")
  public Response salvar(@RequestBody VooCordenadaAcao entity) throws GeoGedException {
    Response response;
    var tmp = vooCordenadaAcaoService.save(entity);
    if (tmp != null) {
      response = Response.ok(tmp).build();
    } else {
      response = Response.noContent().build();
    }
    return response;
  }

}
