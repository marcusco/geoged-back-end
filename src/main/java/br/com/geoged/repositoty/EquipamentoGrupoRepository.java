package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.EquipamentoGrupo;

public interface EquipamentoGrupoRepository extends JpaRepository<EquipamentoGrupo, Integer> {

  @Query("select e from EquipamentoGrupo e where e.tenantId = :tenantId and e.nome = :nome")
  EquipamentoGrupo findByNome(@Param("tenantId") Integer tenantId, @Param("nome") String nome);

  @Query("select e from EquipamentoGrupo e where e.tenantId = :tenantId")
  List<EquipamentoGrupo> findTenantId(@Param("tenantId") Integer tenantId);

}
