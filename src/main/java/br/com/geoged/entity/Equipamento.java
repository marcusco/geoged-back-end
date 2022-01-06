package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import br.com.geoged.enums.EquipamentoTipoEnum;
import br.com.geoged.util.SchemaUtil;


@Entity
@Table(name = "equipamento", schema = SchemaUtil.DEFAULT, uniqueConstraints = @UniqueConstraint(columnNames = {
		"tenant_id", "serie"}))
public class Equipamento extends EntityBase implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "EQUIPAMENTO_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_equipamento", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EQUIPAMENTO_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id")
	private Integer				tenant_id;
	@Column(name = "nome", length = 255)
	private String					nome;
	@Column(name = "descricao", length = 255, nullable = false)
	private String					descricao;
	@Column(name = "serie", length = 255, nullable = false)
	private String					serie;
	@Column(name = "tipo", nullable = false)
	private Integer				tipo;
	@Transient
	private Integer				idExterno;
	//
	public Equipamento()
	{
		super();
	}

	public Equipamento(Integer id)
	{
		super();
		this.id = id;
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

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public String getSerie()
	{
		return serie;
	}

	public void setSerie(String serie)
	{
		this.serie = serie;
	}

	public EquipamentoTipoEnum getTipo()
	{
		return tipo != null ? EquipamentoTipoEnum.getEnum(tipo) : null;
	}

	public void setTipo(EquipamentoTipoEnum tipo)
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
		return Objects.hash(descricao, id, nome, serie, tenant_id, tipo);
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
		Equipamento other = (Equipamento) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(serie, other.serie) && Objects.equals(tenant_id, other.tenant_id) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString()
	{
		return "Equipamento [id=" + id + ", tenant_id=" + tenant_id + ", nome=" + nome + ", descricao=" + descricao + ", serie=" + serie + ", tipo=" + tipo + "]";
	}
}
