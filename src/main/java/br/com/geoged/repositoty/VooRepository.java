package br.com.geoged.repositoty;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.Voo;

public interface VooRepository extends JpaRepository<Voo, Integer> {


  @Query("select e from Voo e where e.tenantId = :tenantId and e.nome = :nome")
  Voo findByNome(@Param("tenantId") Integer tenantId, @Param("nome") String nome);

  @Query("select e from Voo e where e.tenantId = :tenantId and e.descricao = :descricao")
  Voo findByDescricao(@Param("tenantId") Integer tenantId, @Param("descricao") String descricao);

  @Query("select e from Voo e where e.tenantId = :tenantId and e.descricao = :descricao")
  Optional<List<Voo>> findByTenantId(@Param("tenantId") Integer tenantId);
}
