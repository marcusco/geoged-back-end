package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import br.com.geoged.enums.AcaoTipoEnum;
import br.com.geoged.util.SchemaUtil;


@Entity
@Table(name = "acaotipo", schema = SchemaUtil.DEFAULT, uniqueConstraints = {
		@UniqueConstraint(columnNames = {"tenant_id", "nome"}),
		@UniqueConstraint(columnNames = {"tenant_id", "tipo"})})
public class AcaoTipo implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SchemaUtil.DEFAULT + ".seq_equipe")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id")
	private Integer				tenantId;
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

	public Integer getTenantId()
	{
		return tenantId;
	}

	public void setTenantId(Integer tenantId)
	{
		this.tenantId = tenantId;
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
		return Objects.hash(id, nome, tenantId, tipo);
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
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(tenantId, other.tenantId) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString()
	{
		return "AcaoTipo [id=" + id + ", tenantId=" + tenantId + ", nome=" + nome + ", tipo=" + tipo + "]";
	}
}
