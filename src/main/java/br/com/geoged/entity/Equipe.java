package br.com.geoged.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import br.com.geoged.util.SchemaUtil;


@Entity
@Table(name = "equipe", schema = SchemaUtil.DEFAULT, uniqueConstraints = {
		@UniqueConstraint(columnNames = {"tenant_id", "nome"})})
public class Equipe implements Serializable
{
	/**
	* 
	*/
	private static final long			serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SchemaUtil.DEFAULT + ".seq_equipe")
	@Column(name = "id", nullable = false)
	private Integer						id;
	@Column(name = "tenant_id")
	private Integer						tenantId;
	@Column(name = "nome", length = 255, nullable = false)
	private String							nome;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataregistro", nullable = false)
	private Calendar						dataRegistro;
	@Transient
	private List<EquipeColaborador>	colaboradores		= null;
	public Equipe()
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
		return Objects.hash(id, nome, tenantId);
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
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(tenantId, other.tenantId);
	}

	@Override
	public String toString()
	{
		return "Equipe [id=" + id + ", tenantId=" + tenantId + ", nome=" + nome + "]";
	}
}
