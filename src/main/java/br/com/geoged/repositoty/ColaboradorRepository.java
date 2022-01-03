package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.Colaborador;


public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>
{
	@Query("select a from Colaborador a where a.tenant_id = :tenant_id and a.nome = :nome")
	Colaborador findByNome(@Param("tenant_id") Integer tenant_id, @Param("nome") String nome);

	@Query("select a from Colaborador a where a.tenant_id = :tenant_id")
	List<Colaborador> findByTenant_id(@Param("tenant_id") Integer tenant_id);
}
