package br.com.geoged.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.Usuario;
import br.com.geoged.exceptions.GeoGedException;
import br.com.geoged.exceptions.UsuarioExistsException;
import br.com.geoged.repositoty.UsuarioRepository;
import br.com.geoged.service.UsuarioService;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends ServiceBaseImpl<Usuario> implements UsuarioService
{

	private final UsuarioRepository usuarioRepository;
	//
	@Override
	@Transactional(value = Transactional.TxType.REQUIRED)
	public Usuario save(Usuario entity) throws GeoGedException
	{
		super.save(entity);
		//
		try
		{
			return usuarioRepository.save(entity);
		}
		catch (Exception e)
		{
			if(e instanceof SQLException)
			{
				throw e;
			}
			else
			{
				throw new UsuarioExistsException();
			}
		}
	}

	public Optional<Usuario> findById(Integer id)
	{
		return usuarioRepository.findById(id);
	}

	@Override
	public void delete(Usuario entity)
	{
		usuarioRepository.delete(entity);
	}

	@Override
	public List<Usuario> findByTenantId(Integer tenantId)
	{
		return usuarioRepository.findByTenant_id(tenantId);
	}

	@Override
	public List<Usuario> findByEmail(String email)
	{
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public List<Usuario> findAll(Integer tenantId)
	{
		return null;
	}
}
