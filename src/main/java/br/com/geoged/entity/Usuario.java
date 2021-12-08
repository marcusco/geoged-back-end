package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import br.com.geoged.util.SchemaUtil;


@Entity
@Table(name = "usuario", schema = SchemaUtil.DEFAULT, uniqueConstraints = @UniqueConstraint(columnNames = {
		"tenant_id", "email"}))
public class Usuario implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SchemaUtil.DEFAULT + ".seq_usuario")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id", nullable = false)
	private Integer				tenantId;
	@Column(name = "nome", length = 255, nullable = false)
	private String					nome;
	@Column(name = "email", length = 255, nullable = false)
	private String					email;
	@Column(name = "senha", length = 255, nullable = false)
	private String					senha;
	//
	public Usuario()
	{
		super();
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Integer getTenantId()
	{
		return tenantId;
	}

	public void setTenantId(Integer tenantId)
	{
		this.tenantId = tenantId;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(email, id, nome, senha, tenantId);
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha) && Objects.equals(tenantId, other.tenantId);
	}

	@Override
	public String toString()
	{
		return "Usuario [id=" + id + ", tenantId=" + tenantId + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
}
