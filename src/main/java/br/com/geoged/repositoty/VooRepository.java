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
	public Voo findByNome(Integer tenant_id, @Param("nome") String nome);

	@Query("select e from Voo e where e.tenant_id = :tenant_id and e.descricao = :descricao")
	public Voo findByDescricao(Integer tenant_id, String descricao);

	@Query("select e from Voo e where e.tenant_id = :tenant_id")
	public Optional<List<Voo>> findByTenant_id( Integer tenant_id);

	@Query("select e from Voo e where e.tenant_id = :tenant_id and e.descricao = :descricao and e.nome = :nome and e.dataRegistro = :dataRegistro")
	public Voo findByTenantIAndDescricaoAndNomeAndDataRegistro(Integer tenant_id,  String descricao,  String nome, Calendar dataRegistro);

	@Query("select e from Voo e where e.tenant_id = :tenant_id and e.nome = :nome and e.dataRegistro = :dataRegistro")
	public Voo findByTenantIAndNomeAndDataRegistro(Integer tenant_id,  String nome, Calendar dataRegistro);

	@Query("select count(e) from Voo e where e.tenant_id = :tenant_id")
	public Integer countByTenantI( Integer tenant_id);

}
