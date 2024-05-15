package br.com.geoged.repositoty;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>
{
	@Query("select u from Usuario u where u.email = :email")
	public List<Usuario> findByEmail(@Param("email") String email);

	@Query("select u from Usuario u where u.tenant_id = :tenant_id")
	public List<Usuario> findByTenant_id(@Param("tenant_id") Integer tenant_id);
}
