package br.com.geoged.service;

import java.util.List;
import br.com.geoged.entity.EquipamentoGrupo;


public interface EquipamentoGrupoService extends IServiceBase<EquipamentoGrupo> {

  public EquipamentoGrupo findByNome(Integer tenantId, String nome);

  public List<EquipamentoGrupo> findByTenantId(Integer tenantId);

}
