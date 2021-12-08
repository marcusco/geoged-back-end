package br.com.geoged.service;

import java.util.List;
import br.com.geoged.entity.VooCordenadaAcao;

public interface VooCordenadaAcaoService extends IServiceBase<VooCordenadaAcao> {

  public List<VooCordenadaAcao> saveAll(List<VooCordenadaAcao> cordenadaAcoes);

  public List<VooCordenadaAcao> findByTenantId(Integer tenantId);

}
