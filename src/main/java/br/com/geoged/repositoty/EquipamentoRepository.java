package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.Equipamento;


public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer>
{
	@Query("select e from Equipamento e where e.tenant_id = :tenant_id and e.nome = :nome")
	Equipamento findByNome(@Param("tenant_id") Integer tenant_id, @Param("nome") String nome);

	@Query("select e from Equipamento e where e.tenant_id = :tenant_id")
	List<Equipamento> findTenant_id(@Param("tenant_id") Integer tenant_id);
}
