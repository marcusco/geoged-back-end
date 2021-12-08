package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

  @Query("select a from Colaborador a where a.tenantId = :tenantId and a.nome = :nome")
  Colaborador findByNome(@Param("tenantId") Integer tenantId, @Param("nome") String nome);

  @Query("select a from Colaborador a where a.tenantId = :tenantId")
  List<Colaborador> findByTenantId(@Param("tenantId") Integer tenantId);
}
