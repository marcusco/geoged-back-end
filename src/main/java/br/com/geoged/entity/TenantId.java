package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import br.com.geoged.util.SchemaUtil;


@Entity
@Table(name = "tenant_id", schema = SchemaUtil.DEFAULT, uniqueConstraints = @UniqueConstraint(columnNames = {
		"razaosocial", "cpfcnpj"}))
public class TenantId extends EntityBase implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "TENANT_ID_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_tenant_id", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TENANT_ID_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "razaosocial", length = 255)
	private String					razaoSocial;
	@Column(name = "nomefantasia", length = 255)
	private String					nomeFantasia;
	@Column(name = "cpfcnpj", length = 255)
	private String					cpfCnpj;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataregistro")
	private Calendar				dataRegistro;
	@Column(name = "ativo")
	private Integer				ativo;
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getRazaoSocial()
	{
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia()
	{
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia)
	{
		this.nomeFantasia = nomeFantasia;
	}

	public String getCpfCnpj()
	{
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj)
	{
		this.cpfCnpj = cpfCnpj;
	}

	public Calendar getDataRegistro()
	{
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro)
	{
		this.dataRegistro = dataRegistro;
	}

	public boolean getAtivo()
	{
		return ativo == 1 ? true : false;
	}

	public void setAtivo(boolean ativo)
	{
		if(ativo)
			this.ativo = 1;
		else
			this.ativo = 0;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(ativo, cpfCnpj, dataRegistro, id, nomeFantasia, razaoSocial);
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
		TenantId other = (TenantId) obj;
		return Objects.equals(ativo, other.ativo) && Objects.equals(cpfCnpj, other.cpfCnpj) && Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(id, other.id) && Objects.equals(nomeFantasia, other.nomeFantasia) && Objects.equals(razaoSocial, other.razaoSocial);
	}

	@Override
	public String toString()
	{
		return "TenantId [id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", cpfCnpj=" + cpfCnpj + ", dataRegistro=" + dataRegistro + ", ativo=" + ativo + "]";
	}
}
