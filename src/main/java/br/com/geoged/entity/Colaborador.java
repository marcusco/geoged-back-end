package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Objects;
import br.com.geoged.util.SchemaUtil;
import jakarta.persistence.*;


@Entity
@Table(name = "colaborador", schema = SchemaUtil.DEFAULT, uniqueConstraints = @UniqueConstraint(columnNames = {
		"tenant_id", "nome", "cpfcnpj"}))
public class Colaborador extends EntityBase implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "COLABORADOR_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_colaborador", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLABORADOR_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id")
	private Integer				tenant_id;
	@Column(name = "nome", length = 255)
	private String					nome;
	@Column(name = "cpfcnpj", length = 255)
	private String					cpfCnpj;
	@Transient
	private Integer				idExterno;
	//
	public Colaborador()
	{
		super();
	}

	public Integer getIdExterno()
	{
		return id;
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

	public String getCpfCnpj()
	{
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj)
	{
		this.cpfCnpj = cpfCnpj;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(cpfCnpj, id, nome, tenant_id);
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
		Colaborador other = (Colaborador) obj;
		return Objects.equals(cpfCnpj, other.cpfCnpj) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(tenant_id, other.tenant_id);
	}

	@Override
	public String toString()
	{
		return "Colaborador [id=" + id + ", tenant_id=" + tenant_id + ", nome=" + nome + ", cpfCnpj=" + cpfCnpj + "]";
	}
}
