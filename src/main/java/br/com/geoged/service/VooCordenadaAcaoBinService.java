package br.com.geoged.service;

import java.util.List;
import br.com.geoged.entity.VooCordenadaAcaoBin;

public interface VooCordenadaAcaoBinService extends IServiceBase<VooCordenadaAcaoBin> {

  public List<VooCordenadaAcaoBin> findByTenantId(Integer tenantId);

}
