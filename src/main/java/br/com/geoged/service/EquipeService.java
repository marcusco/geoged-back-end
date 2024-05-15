package br.com.geoged.service;

import java.util.List;
import br.com.geoged.entity.Equipe;


public interface EquipeService extends IServiceBase<Equipe> {

  public Equipe findByNome(Integer tenantId, String nome);

  public List<Equipe> findByTenantId(Integer tenantId);


}
