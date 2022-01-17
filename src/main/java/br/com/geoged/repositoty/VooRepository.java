package br.com.geoged.repositoty;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.Voo;


public interface VooRepository extends JpaRepository<Voo, Integer>
{
	@Query("select e from Voo e where e.tenant_id = :tenant_id and e.nome = :nome")
	public Voo findByNome(@Param("tenant_id") Integer tenant_id, @Param("nome") String nome);

	@Query("select e from Voo e where e.tenant_id = :tenant_id and e.descricao = :descricao")
	public Voo findByDescricao(@Param("tenant_id") Integer tenant_id, @Param("descricao") String descricao);

	@Query("select e from Voo e where e.tenant_id = :tenant_id and e.descricao = :descricao")
	public Optional<List<Voo>> findBytenant_id(@Param("tenant_id") Integer tenant_id);

	@Query("select e from Voo e where e.tenant_id = :tenant_id and e.descricao = :descricao and e.nome = :nome and e.dataRegistro = :dataRegistro")
	public Voo findByTenantIAndDescricaoAndNomeAndDataRegistro(@Param("tenant_id") Integer tenant_id, @Param("descricao") String descricao, @Param("nome") String nome, @Param("dataRegistro") Calendar dataRegistro);

	@Query("select e from Voo e where e.tenant_id = :tenant_id and e.nome = :nome and e.dataRegistro = :dataRegistro")
	public Voo findByTenantIAndNomeAndDataRegistro(@Param("tenant_id") Integer tenant_id, @Param("nome") String nome, @Param("dataRegistro") Calendar dataRegistro);
}
