package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.Equipe;


public interface EquipeRepository extends JpaRepository<Equipe, Integer>
{
	@Query("select e from Equipe e where e.tenant_id = :tenantId and e.nome = :nome")
	Equipe findByNome(@Param("tenantId") Integer tenantId, @Param("nome") String nome);

	@Query("select e from Equipe e where e.tenant_id = :tenantId")
	List<Equipe> findByTenantId(@Param("tenantId") Integer tenantId);
}
