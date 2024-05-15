package br.com.geoged.service;

import java.util.List;
import br.com.geoged.entity.Equipamento;


public interface EquipamentoService extends IServiceBase<Equipamento> {

  public Equipamento findByNome(Integer tenantId, String nome);

  public List<Equipamento> findByTenantId(Integer tenantId);

}
