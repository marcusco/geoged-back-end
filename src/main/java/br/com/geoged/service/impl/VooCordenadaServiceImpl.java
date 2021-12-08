package br.com.geoged.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.VooCordenada;
import br.com.geoged.entity.VooCordenadaAcao;
import br.com.geoged.repositoty.VooCordenadaRepository;
import br.com.geoged.service.VooCordenadaAcaoService;
import br.com.geoged.service.VooCordenadaService;


@Service
public class VooCordenadaServiceImpl extends ServiceBaseImpl<VooCordenada>
    implements VooCordenadaService {

  @Autowired
  private VooCordenadaRepository vooCordenadaRepository;
  @Autowired
  private VooCordenadaAcaoService vooCordenadaAcaoService;

  @Override
  public VooCordenada save(VooCordenada entity) {
    List<VooCordenadaAcao> tmp = new ArrayList<>();
    tmp.addAll(vooCordenadaAcaoService.saveAll(entity.getAcoes()));
    entity.setAcoes(tmp);
    return vooCordenadaRepository.save(entity);
  }

  public Optional<VooCordenada> findById(Integer id) {
    return vooCordenadaRepository.findById(id);
  }

  @Override
  public void delete(VooCordenada entity) {
    vooCordenadaRepository.delete(entity);
  }

  @Override
  public List<VooCordenada> findAll(Integer tenantId) {
    return vooCordenadaRepository.findAll();
  }

  @Override
  public List<VooCordenada> saveAll(List<VooCordenada> cordenadas) {
    List<VooCordenada> tmp = new ArrayList<>();
    for (VooCordenada cordenada : cordenadas) {
      tmp.add(save(cordenada));
    }
    return tmp;
  }

  @Override
  public List<VooCordenada> findByTenantId(Integer tenantId) {
    return null;
  }
}
