package br.com.geoged.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.geoged.util.SchemaUtil;
import jakarta.persistence.*;


@Entity
@Table(name = "equipe", schema = SchemaUtil.DEFAULT, uniqueConstraints = {
		@UniqueConstraint(columnNames = {"tenant_id", "nome"})})
public class Equipe extends EntityBase implements Serializable
{
	/**
	* 
	*/@Serial
	private static final long			serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "EQUIPE_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_equipe", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EQUIPE_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer						id;
	@Column(name = "tenant_id")
	private Integer						tenant_id;
	@Column(name = "nome", length = 255, nullable = false)
	private String							nome;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataregistro", nullable = false)
	private Calendar						dataRegistro;
	@Transient
	private Integer						idExterno;
	@Transient
	private List<EquipeColaborador>	colaboradores		= null;
	//
	public Equipe()
	{
		super();
	}

	public Equipe(Integer id)
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

	public List<EquipeColaborador> getColaboradores()
	{
		if(colaboradores == null)
		{
			colaboradores = new ArrayList<>();
		}
		return colaboradores;
	}

	public void setColaboradores(List<EquipeColaborador> colaboradores)
	{
		this.colaboradores = colaboradores;
	}

	public Calendar getDataRegistro()
	{
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro)
	{
		this.dataRegistro = dataRegistro;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(colaboradores, dataRegistro, id, idExterno, nome, tenant_id);
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
		Equipe other = (Equipe) obj;
		return Objects.equals(colaboradores, other.colaboradores) && Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(id, other.id) && Objects.equals(idExterno, other.idExterno) && Objects.equals(nome, other.nome) && Objects.equals(tenant_id, other.tenant_id);
	}

	@Override
	public String toString()
	{
		return "Equipe [id=" + id + ", tenant_id=" + tenant_id + ", nome=" + nome + ", dataRegistro=" + dataRegistro + ", idExterno=" + idExterno + ", colaboradores=" + colaboradores + "]";
	}
}
