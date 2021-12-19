package br.com.geoged.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.EquipeColaborador;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.repositoty.EquipeColaboradorRepository;
import br.com.geoged.service.EquipeColaboradorService;


@Service
public class EquipeColaboradorServiceImpl extends ServiceBaseImpl<EquipeColaborador>
    implements EquipeColaboradorService {

  @Autowired
  private EquipeColaboradorRepository equipeColaboradorRepository;

  @Override
  public EquipeColaborador save(EquipeColaborador entity) {
    return equipeColaboradorRepository.save(entity);
  }

  @Override
  public Optional<EquipeColaborador> findById(Integer id) {
    return equipeColaboradorRepository.findById(id);
  }

  @Override
  public void delete(EquipeColaborador entity) throws GeoGedException {
    equipeColaboradorRepository.delete(entity);

  }

  @Override
  public List<EquipeColaborador> findAll(Integer tenantId) {
    return null;
  }

  @Override
  public List<EquipeColaborador> findByTenantIdAndIdEquipe(Integer tenantId, Integer idEquipe) {
    return equipeColaboradorRepository.findByTenantIdAndIdEquipe(tenantId, idEquipe);
  }


}