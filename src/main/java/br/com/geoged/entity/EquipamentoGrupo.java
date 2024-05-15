package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Objects;
import br.com.geoged.util.SchemaUtil;
import jakarta.persistence.*;


@Entity
@Table(name = "equipamentogrupo", schema = SchemaUtil.DEFAULT, uniqueConstraints = {
		@UniqueConstraint(columnNames = {"tenant_id", "nome"}),
		@UniqueConstraint(columnNames = {"tenant_id", "idequipamento"})})
public class EquipamentoGrupo extends EntityBase implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "EQUIPAMENTO_GRUPO_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_equipamentogrupo", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EQUIPAMENTO_GRUPO_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id")
	private Integer				tenant_id;
	@Column(name = "nome", length = 255, nullable = false)
	private String					nome;
	@JoinColumn(name = "idequipamento", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Equipamento			equipamento;
	@Transient
	private Integer				idExterno;
	//
	public EquipamentoGrupo()
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

	public Integer getTenant_id()
	{
		return tenant_id;
	}

	public void setTenant_id(Integer tenant_id)
	{
		this.tenant_id = tenant_id;
	}

	public Equipamento getEquipamento()
	{
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento)
	{
		this.equipamento = equipamento;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(equipamento, id, nome, tenant_id);
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
		EquipamentoGrupo other = (EquipamentoGrupo) obj;
		return Objects.equals(equipamento, other.equipamento) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(tenant_id, other.tenant_id);
	}

	@Override
	public String toString()
	{
		return "EquipamentoGrupo [id=" + id + ", tenant_id=" + tenant_id + ", nome=" + nome + ", equipamento=" + equipamento + "]";
	}
}
