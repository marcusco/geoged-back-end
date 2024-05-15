package br.com.geoged.service;

import java.util.List;
import br.com.geoged.entity.EquipeColaborador;


public interface EquipeColaboradorService extends IServiceBase<EquipeColaborador> {

  public List<EquipeColaborador> findByTenantIdAndIdEquipe(Integer tenantId, Integer idEquipe);

}
