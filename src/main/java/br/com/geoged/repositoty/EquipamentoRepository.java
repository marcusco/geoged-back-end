package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {

  @Query("select e from Equipamento e where e.tenantId = :tenantId and e.nome = :nome")
  public Equipamento findByNome(@Param("tenantId") Integer tenantId, @Param("nome") String nome);

  @Query("select e from Equipamento e where e.tenantId = :tenantId")
  public List<Equipamento> findTenantId(@Param("tenantId") Integer tenantId);

}
