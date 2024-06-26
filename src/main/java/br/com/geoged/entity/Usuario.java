package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Objects;
import br.com.geoged.util.SchemaUtil;
import jakarta.persistence.*;


@Entity
@Table(name = "usuario", schema = SchemaUtil.DEFAULT, uniqueConstraints = @UniqueConstraint(columnNames = {
		"tenant_id", "email"}))
public class Usuario extends EntityBase implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "USUARIO_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_usuario", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id", nullable = false)
	private Integer				tenant_id;
	@Column(name = "nome", length = 255, nullable = false)
	private String					nome;
	@Column(name = "email", length = 255, nullable = false)
	private String					email;
	@Column(name = "senha", length = 255, nullable = false)
	private String					senha;
	@Transient
	private Integer				idExterno;
	//
	public Usuario()
	{
		super();
	}

	public Usuario(Integer id)
	{
		super();
		this.id = id;
	}

	public Integer getIdExterno()
	{
		return idExterno;
	}

	public void setIdExterno(Integer idExterno)
	{
		this.idExterno = idExterno;
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

	public Integer getTenant_id()
	{
		return tenant_id;
	}

	public void setTenant_id(Integer tenant_id)
	{
		this.tenant_id = tenant_id;
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
		return Objects.hash(email, id, idExterno, nome, senha, tenant_id);
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
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(idExterno, other.idExterno) && Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha) && Objects.equals(tenant_id, other.tenant_id);
	}

	@Override
	public String toString()
	{
		return "Usuario [id=" + id + ", tenant_id=" + tenant_id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", idExterno=" + idExterno + "]";
	}
}
