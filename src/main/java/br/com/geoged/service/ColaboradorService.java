package br.com.geoged.service;

import java.util.List;
import br.com.geoged.entity.Colaborador;


public interface ColaboradorService extends IServiceBase<Colaborador> {

  public Colaborador findByNome(Integer tenantId, String nome);

  public List<Colaborador> findByTenantId(Integer tenantId);


}
