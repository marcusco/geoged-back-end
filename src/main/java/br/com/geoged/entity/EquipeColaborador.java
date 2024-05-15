package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Objects;
import br.com.geoged.util.SchemaUtil;
import jakarta.persistence.*;


@Entity
@Table(name = "equipecolaborador", schema = SchemaUtil.DEFAULT, uniqueConstraints = {
		@UniqueConstraint(columnNames = {"tenant_id", "idcolaborador", "idequipe"})})
public class EquipeColaborador extends EntityBase implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "EQUIPE_COLABORADOR_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_equipecolaborador", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EQUIPE_COLABORADOR_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id")
	private Integer				tenant_id;
	@Column(name = "nome", length = 255, nullable = false)
	private String					nome;
	@JoinColumn(name = "idcolaborador", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Colaborador			colaborador;
	@JoinColumn(name = "idequipe", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Equipe					equipe;
	@Transient
	private Integer				idExterno;
	//
	public EquipeColaborador()
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

	public Colaborador getColaborador()
	{
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador)
	{
		this.colaborador = colaborador;
	}

	public Equipe getEquipe()
	{
		return equipe;
	}

	public void setEquipe(Equipe equipe)
	{
		this.equipe = equipe;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(colaborador, equipe, id, nome, tenant_id);
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
		EquipeColaborador other = (EquipeColaborador) obj;
		return Objects.equals(colaborador, other.colaborador) && Objects.equals(equipe, other.equipe) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(tenant_id, other.tenant_id);
	}

	@Override
	public String toString()
	{
		return "EquipeColaborador [id=" + id + ", tenant_id=" + tenant_id + ", nome=" + nome + ", colaborador=" + colaborador + ", equipe=" + equipe + "]";
	}
}
