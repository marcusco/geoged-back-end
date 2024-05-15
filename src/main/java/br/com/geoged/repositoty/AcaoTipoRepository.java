package br.com.geoged.repositoty;

import br.com.geoged.entity.AcaoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface AcaoTipoRepository extends JpaRepository<AcaoTipo, Integer>
{
	@Query("select a from AcaoTipo a where a.tenant_id = :tenant_id and a.tipo = :tipo")
	 AcaoTipo findByTipo(Integer tenant_id, Integer tipo);

	@Query("select a from AcaoTipo a where a.tenant_id = :tenant_id and a.nome = :nome")
	 AcaoTipo findByNome(Integer tenant_id,  String nome);

	@Query("select c from AcaoTipo c  where c.tenant_id = :tenant_id")
	 List<AcaoTipo> findByTenant_id( Integer tenant_id);
}
