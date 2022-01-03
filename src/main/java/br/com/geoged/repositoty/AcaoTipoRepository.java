package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.AcaoTipo;


public interface AcaoTipoRepository extends JpaRepository<AcaoTipo, Integer>
{
	@Query("select a from AcaoTipo a where a.tenant_id = :tenant_id and a.tipo = :tipo")
	public AcaoTipo findByTipo(@Param("tenant_id") Integer tenant_id, @Param("tipo") Integer tipo);

	@Query("select a from AcaoTipo a where a.tenant_id = :tenant_id and a.nome = :nome")
	public AcaoTipo findByNome(@Param("tenant_id") Integer tenant_id, @Param("nome") String nome);

	@Query("select c from AcaoTipo c  where c.tenant_id = :tenant_id")
	public List<AcaoTipo> findByTenant_id(@Param("tenant_id") Integer tenant_id);
}
