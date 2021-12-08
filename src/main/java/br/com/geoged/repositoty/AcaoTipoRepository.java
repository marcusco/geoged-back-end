package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.AcaoTipo;


public interface AcaoTipoRepository extends JpaRepository<AcaoTipo, Integer>
{
	@Query("select a from AcaoTipo a where a.tenantId = :tenantId and a.tipo = :tipo")
	public AcaoTipo findByTipo(@Param("tenantId") Integer tenantId, @Param("tipo") Integer tipo);

	@Query("select a from AcaoTipo a where a.tenantId = :tenantId and a.nome = :nome")
	public AcaoTipo findByNome(@Param("tenantId") Integer tenantId, @Param("nome") String nome);

	@Query("select c from AcaoTipo c  where c.tenantId = :tenantId")
	public List<AcaoTipo> findByTenantId(@Param("tenantId") Integer tenantId);
}
