package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Arrays;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.geoged.util.SchemaUtil;


@Entity
@Table(name = "voocordenadaacao", schema = SchemaUtil.DEFAULT)
public class VooCordenadaAcao extends EntityBase implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "VOO_CORDENADA_ACAO_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_voocordenadaacao", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOO_CORDENADA_ACAO_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id")
	private Integer				tenant_id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataregistro", nullable = false)
	private Calendar				dataRegistro;
	@JoinColumn(name = "idacaotipo", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private AcaoTipo				acaoTipo;
	@Column(name = "valorclob", columnDefinition = "text")
	private String					valorClob;
	@Column(name = "valorblob", columnDefinition = "blob")
	private byte[]					valorBlob;
	@JoinColumn(name = "idvoocordenada", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private VooCordenada			vooCordenada;
	@Transient
	private Integer				idExterno;
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

	public Integer getTenant_id()
	{
		return tenant_id;
	}

	public void setTenant_id(Integer tenant_id)
	{
		this.tenant_id = tenant_id;
	}

	public AcaoTipo getAcaoTipo()
	{
		return acaoTipo;
	}

	public void setAcaoTipo(AcaoTipo acaoTipo)
	{
		this.acaoTipo = acaoTipo;
	}

	public Calendar getDataRegistro()
	{
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro)
	{
		this.dataRegistro = dataRegistro;
	}

	public String getValorClob()
	{
		return valorClob;
	}

	public void setValorClob(String valorClob)
	{
		this.valorClob = valorClob;
	}

	public byte[] getValorBlob()
	{
		return valorBlob;
	}

	public void setValorBlob(byte[] valorBlob)
	{
		this.valorBlob = valorBlob;
	}

	public VooCordenada getVooCordenada()
	{
		return vooCordenada;
	}

	public void setVooCordenada(VooCordenada vooCordenada)
	{
		this.vooCordenada = vooCordenada;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(valorBlob);
		result = prime * result + Objects.hash(acaoTipo, dataRegistro, id, idExterno, tenant_id, valorClob, vooCordenada);
		return result;
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
		return Objects.equals(acaoTipo, other.acaoTipo) && Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(id, other.id) && Objects.equals(idExterno, other.idExterno) && Objects.equals(tenant_id, other.tenant_id) && Arrays.equals(valorBlob, other.valorBlob) && Objects.equals(valorClob, other.valorClob) && Objects.equals(vooCordenada, other.vooCordenada);
	}

	@Override
	public String toString()
	{
		return "VooCordenadaAcao [id=" + id + ", tenant_id=" + tenant_id + ", dataRegistro=" + dataRegistro + ", acaoTipo=" + acaoTipo + ", valorClob=" + valorClob + ", valorBlob=" + Arrays.toString(valorBlob) + ", vooCordenada=" + vooCordenada + ", idExterno=" + idExterno + "]";
	}
}
