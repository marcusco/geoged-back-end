package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.EquipeColaborador;


public interface EquipeColaboradorRepository extends JpaRepository<EquipeColaborador, Integer>
{
	@Query("select e from EquipeColaborador e where e.tenant_id = :tenant_id and e.equipe = :idEquipe")
	public List<EquipeColaborador> findByTenant_idAndIdEquipe(@Param("tenant_id") Integer tenant_id, @Param("idEquipe") Integer idEquipe);
}
