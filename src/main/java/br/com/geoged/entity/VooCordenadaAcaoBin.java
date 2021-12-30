package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
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
import br.com.geoged.util.SchemaUtil;


@Entity
@Table(name = "voocordenadaacaobin", schema = SchemaUtil.DEFAULT)
public class VooCordenadaAcaoBin implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SchemaUtil.DEFAULT + ".seq_voocordenadaacaobin")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id")
	private Integer				tenantId;
	@Column(name = "tipo", nullable = false, length = 1)
	private String					tipo;
	@Column(name = "nomearquivo", nullable = true, length = 255)
	private String					nomeArquivo;
	@Column(name = "extensao", nullable = true, length = 255)
	private String					extensao;
	@Column(name = "mimetype", nullable = true, length = 255)
	private String					mimeType;
	@Column(name = "valorclob", columnDefinition = "text")
	private String					valorClob;
	@Column(name = "valorblob", columnDefinition = "blob")
	private byte[]					valorBlob;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataregistro", nullable = false)
	private Calendar				dataRegistro;
	@Transient
	private Integer				idExterno;
	public VooCordenadaAcaoBin()
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

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public String getNomeArquivo()
	{
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo)
	{
		this.nomeArquivo = nomeArquivo;
	}

	public String getExtensao()
	{
		return extensao;
	}

	public void setExtensao(String extensao)
	{
		this.extensao = extensao;
	}

	public String getMimeType()
	{
		return mimeType;
	}

	public void setMimeType(String mimeType)
	{
		this.mimeType = mimeType;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(valorBlob);
		result = prime * result + Objects.hash(dataRegistro, extensao, id, mimeType, nomeArquivo, tenantId, tipo, valorClob);
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
		VooCordenadaAcaoBin other = (VooCordenadaAcaoBin) obj;
		return Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(extensao, other.extensao) && Objects.equals(id, other.id) && Objects.equals(mimeType, other.mimeType) && Objects.equals(nomeArquivo, other.nomeArquivo) && Objects.equals(tenantId, other.tenantId) && Objects.equals(tipo, other.tipo) && Arrays.equals(valorBlob, other.valorBlob) && Objects.equals(valorClob, other.valorClob);
	}

	@Override
	public String toString()
	{
		return "VooCoordenadaAcaoBin [id=" + id + ", tenantId=" + tenantId + ", tipo=" + tipo + ", nomeArquivo=" + nomeArquivo + ", extensao=" + extensao + ", mimeType=" + mimeType + ", valorClob=" + valorClob + ", valorBlob=" + Arrays.toString(valorBlob) + ", dataRegistro=" + dataRegistro + "]";
	}
}
