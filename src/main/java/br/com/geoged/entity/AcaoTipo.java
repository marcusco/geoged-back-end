package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Objects;
import br.com.geoged.enums.AcaoTipoEnum;
import br.com.geoged.util.SchemaUtil;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "acaotipo", schema = SchemaUtil.DEFAULT, uniqueConstraints = {
		@UniqueConstraint(columnNames = {"tenant_id", "nome"}),
		@UniqueConstraint(columnNames = {"tenant_id", "tipo"})})
public class AcaoTipo extends EntityBase implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "ACAO_TIPO_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_acaotipo", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACAO_TIPO_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id")
	private Integer				tenant_id;
	@NotEmpty(message = "campo.obrigatorio")
	@Column(name = "nome", length = 255, nullable = false)
	private String					nome;
	@Column(name = "tipo", nullable = false)
	private Integer				tipo;
	@Transient
	private Integer				idExterno;
	//
	public AcaoTipo()
	{
		super();
	}

	public AcaoTipo(Integer id)
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

	public AcaoTipoEnum getTipo()
	{
		if(tipo != null)
		{
			return AcaoTipoEnum.getEnum(tipo);
		}
		else
		{
			return null;
		}
	}

	public void setTipo(AcaoTipoEnum tipo)
	{
		if(tipo != null)
		{
			this.tipo = tipo.getCodigo();
		}
		else
		{
			this.tipo = null;
		}
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, nome, tenant_id, tipo);
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
		AcaoTipo other = (AcaoTipo) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(tenant_id, other.tenant_id) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString()
	{
		return "AcaoTipo [id=" + id + ", tenant_id=" + tenant_id + ", nome=" + nome + ", tipo=" + tipo + "]";
	}
}
