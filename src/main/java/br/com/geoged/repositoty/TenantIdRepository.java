package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.TenantId;


public interface TenantIdRepository extends JpaRepository<TenantId, Integer>
{
	@Query("select t from TenantId t where t.id = :tenantId")
	public List<TenantId> findByTenantId(@Param("tenantId") Integer tenantId);

	@Query("select t from TenantId t")
	public List<TenantId> findByAll();
}
