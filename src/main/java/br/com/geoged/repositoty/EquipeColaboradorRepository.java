package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.EquipeColaborador;

public interface EquipeColaboradorRepository extends JpaRepository<EquipeColaborador, Integer> {

  @Query("select e from EquipeColaborador e where e.tenantId = :tenantId and e.equipe = :idEquipe")
  public List<EquipeColaborador> findByTenantIdAndIdEquipe(@Param("tenantId") Integer tenantId,
      @Param("idEquipe") Integer idEquipe);
}
