package br.com.geoged.rest.resource;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.geoged.entity.Colaborador;
import br.com.geoged.enums.ExceptionCodeEnum;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.ColaboradorService;

@RestController
@RequestMapping(value = "/colaborador", produces = MediaType.APPLICATION_JSON_VALUE)
public class ColaboradorResource {

  @Autowired
  private ColaboradorService colaboradorService;

  @GetMapping(value = "/find_by_nome", produces = MediaType.APPLICATION_JSON_VALUE)
  public Response findByNome(@PathParam(value = "tenantId") Integer tenantId,
      @PathParam(value = "nome") String nome) {
    Response response;
    try {
      var tmp = colaboradorService.findByNome(tenantId, nome);
      if (tmp != null) {
        response = Response.ok(tmp).build();
      } else {
        response = Response.noContent().build();
      }
    } catch (Exception e) {
      response =
          Response.status(ExceptionCodeEnum.GENERIC_APP_ERROR.getCode(), e.getMessage()).build();
    }
    return response;
  }

  @PostMapping(value = "/salvar")
  public Response salvar(@RequestBody Colaborador entity) throws GeoGedException {
    Response response;
    var tmp = colaboradorService.save(entity);
    if (tmp != null) {
      response = Response.ok(tmp).build();
    } else {
      response = Response.noContent().build();
    }
    return response;
  }

  @GetMapping(value = "/find_by_tenant_id")
  public Response findByTenantId(@QueryParam(value = "tenantId") Integer tenantId) {
    Response response;
    List<Colaborador> tmp = colaboradorService.findByTenantId(tenantId);
    if (tmp != null) {
      response = Response.ok(tmp).build();
    } else {
      response = Response.noContent().build();
    }
    return response;
  }

}
