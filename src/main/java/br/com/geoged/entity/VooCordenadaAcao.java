package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import br.com.geoged.util.SchemaUtil;


@Entity
@Table(name = "voocordenadaacao", schema = SchemaUtil.DEFAULT)
public class VooCordenadaAcao implements Serializable
{
	/**
	* 
	*/
	private static final long		serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SchemaUtil.DEFAULT + ".seq_voocordenadaacao")
	@Column(name = "id", nullable = false)
	private Integer					id;
	@Column(name = "tenant_id")
	private Integer					tenantId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataregistro", nullable = false)
	private Calendar					dataRegistro;
	@JoinColumn(name = "idacaotipo", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private AcaoTipo					acaoTipo;
	@JoinColumn(name = "idvoocoordenadaacaobin", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private VooCordenadaAcaoBin	acaoCoordenada;
	@Transient
	private Integer					idExterno;
	//
	public VooCordenadaAcao()
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

	public Integer getTenantId()
	{
		return tenantId;
	}

	public void setTenantId(Integer tenantId)
	{
		this.tenantId = tenantId;
	}

	public AcaoTipo getAcaoTipo()
	{
		return acaoTipo;
	}

	public void setAcaoTipo(AcaoTipo acaoTipo)
	{
		this.acaoTipo = acaoTipo;
	}

	public VooCordenadaAcaoBin getAcaoCoordenada()
	{
		return acaoCoordenada;
	}

	public void setAcaoCoordenada(VooCordenadaAcaoBin acaoCoordenada)
	{
		this.acaoCoordenada = acaoCoordenada;
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
		return Objects.hash(acaoCoordenada, acaoTipo, dataRegistro, id, tenantId);
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
		VooCordenadaAcao other = (VooCordenadaAcao) obj;
		return Objects.equals(acaoCoordenada, other.acaoCoordenada) && Objects.equals(acaoTipo, other.acaoTipo) && Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(id, other.id) && Objects.equals(tenantId, other.tenantId);
	}

	@Override
	public String toString()
	{
		return "VooCoordenadaAcao [id=" + id + ", tenantId=" + tenantId + ", dataRegistro=" + dataRegistro + ", acaoTipo=" + acaoTipo + ", acaoCoordenada=" + acaoCoordenada + "]";
	}
}
