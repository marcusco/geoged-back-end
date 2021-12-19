package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

  @Query("select e from Equipe e where e.tenantId = :tenantId and e.nome = :nome")
  public Equipe findByNome(@Param("tenantId") Integer tenantId, @Param("nome") String nome);

  @Query("select e from Equipe e where e.tenantId = :tenantId")
  public List<Equipe> findByTenantId(@Param("tenantId") Integer tenantId);

}