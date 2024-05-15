package br.com.geoged.service;

import java.util.List;
import br.com.geoged.entity.Usuario;


public interface UsuarioService extends IServiceBase<Usuario>
{
	public List<Usuario> findByEmail(String email);

	public List<Usuario> findByTenantId(Integer tenantId);
}
