package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.geoged.util.SchemaUtil;
import jakarta.persistence.*;


@Entity
@Table(name = "voocordenadaacaobin", schema = SchemaUtil.DEFAULT)
public class VooCordenadaAcaoBin extends EntityBase implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "VOO_CORDENADA_ACAO_BIN_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_voocordenadaacaobin", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOO_CORDENADA_ACAO_BIN_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id")
	private Integer				tenant_id;
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

	public Integer getTenant_id()
	{
		return tenant_id;
	}

	public void setTenant_id(Integer tenant_id)
	{
		this.tenant_id = tenant_id;
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
		result = prime * result + Objects.hash(dataRegistro, extensao, id, mimeType, nomeArquivo, tenant_id, tipo, valorClob);
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
		return Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(extensao, other.extensao) && Objects.equals(id, other.id) && Objects.equals(mimeType, other.mimeType) && Objects.equals(nomeArquivo, other.nomeArquivo) && Objects.equals(tenant_id, other.tenant_id) && Objects.equals(tipo, other.tipo) && Arrays.equals(valorBlob, other.valorBlob) && Objects.equals(valorClob, other.valorClob);
	}

	@Override
	public String toString()
	{
		return "VooCoordenadaAcaoBin [id=" + id + ", tenant_id=" + tenant_id + ", tipo=" + tipo + ", nomeArquivo=" + nomeArquivo + ", extensao=" + extensao + ", mimeType=" + mimeType + ", valorClob=" + valorClob + ", valorBlob=" + Arrays.toString(valorBlob) + ", dataRegistro=" + dataRegistro + "]";
	}
}
