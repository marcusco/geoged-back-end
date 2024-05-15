package br.com.geoged.controller;

import java.util.List;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.geoged.entity.VooCordenadaAcaoBin;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.service.VooCordenadaAcaoBinService;

@RestController
@RequestMapping(value = "/voo_cordenada_acao_bin")
@RequiredArgsConstructor
public class VooCoordenadaAcaoBinController {


  private final VooCordenadaAcaoBinService vooCordenadaAcaoBinService;

  @GetMapping(value = "/find_by_tenant_id")
  public List<VooCordenadaAcaoBin> findByTenantId(Integer tenantId) {

    return vooCordenadaAcaoBinService.findByTenantId(tenantId);

  }

  @PostMapping(value = "/salvar")
  public VooCordenadaAcaoBin salvar(@RequestBody VooCordenadaAcaoBin entity) throws GeoGedException {

    return vooCordenadaAcaoBinService.save(entity);

  }

}
