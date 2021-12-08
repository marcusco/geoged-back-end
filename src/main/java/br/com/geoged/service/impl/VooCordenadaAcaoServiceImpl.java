package br.com.geoged.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.VooCordenadaAcao;
import br.com.geoged.repositoty.VooCordenadaAcaoRepository;
import br.com.geoged.service.VooCordenadaAcaoService;


@Service
public class VooCordenadaAcaoServiceImpl extends ServiceBaseImpl<VooCordenadaAcao>
    implements VooCordenadaAcaoService {

  @Autowired
  private VooCordenadaAcaoRepository vooCordenadaAcaoRepository;

  @Override
  public VooCordenadaAcao save(VooCordenadaAcao entity) {
    return vooCordenadaAcaoRepository.save(entity);
  }

  public Optional<VooCordenadaAcao> findById(Integer id) {
    return vooCordenadaAcaoRepository.findById(id);
  }

  @Override
  public void delete(VooCordenadaAcao entity) {
    vooCordenadaAcaoRepository.delete(entity);
  }

  @Override
  public List<VooCordenadaAcao> findAll(Integer tenantId) {
    return vooCordenadaAcaoRepository.findAll();
  }

  @Override
  public List<VooCordenadaAcao> saveAll(List<VooCordenadaAcao> cordenadaAcoes) {
    List<VooCordenadaAcao> tmp = new ArrayList<>();
    for (VooCordenadaAcao acao : cordenadaAcoes) {
      tmp.add(save(acao));
    }
    return tmp;
  }

  @Override
  public List<VooCordenadaAcao> findByTenantId(Integer tenantId) {
    return null;
  }

}


