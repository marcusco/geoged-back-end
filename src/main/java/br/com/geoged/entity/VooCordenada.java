package br.com.geoged.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.geoged.util.SchemaUtil;


@Entity
@Table(name = "voocordenada", schema = SchemaUtil.DEFAULT, uniqueConstraints = @UniqueConstraint(columnNames = {
		"tenant_id", "idvoo", "dataregistro"}))
public class VooCordenada extends EntityBase implements Serializable
{
	/**
	* 
	*/
	private static final long			serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "VOO_CORDENADA_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_voocordenada", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOO_CORDENADA_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer						id;
	@Column(name = "tenant_id", nullable = false)
	private Integer						tenant_id;
	@Column(name = "latitude", nullable = false, columnDefinition = "double precision")
	private Double							latitude;
	@Column(name = "longitude", nullable = false, columnDefinition = "double precision")
	private Double							longitude;
	@Column(name = "altitude", nullable = false, columnDefinition = "double precision")
	private Double							altitude;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataregistro", nullable = false)
	private Calendar						dataRegistro;
	@JoinColumn(name = "idvoo", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Voo								voo;
	@Transient
	private Integer						idExterno;
	@Transient
	private List<VooCordenadaAcao>	acoes					= null;
	public VooCordenada()
	{
		super();
	}

	public VooCordenada(Integer id)
	{
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

	public Integer getTenant_id()
	{
		return tenant_id;
	}

	public void setTenant_id(Integer tenant_id)
	{
		this.tenant_id = tenant_id;
	}

	public Double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	public Double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

	public Double getAltitude()
	{
		return altitude;
	}

	public void setAltitude(Double altitude)
	{
		this.altitude = altitude;
	}

	public Calendar getDataRegistro()
	{
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro)
	{
		this.dataRegistro = dataRegistro;
	}

	public Voo getVoo()
	{
		return voo;
	}

	public void setVoo(Voo voo)
	{
		this.voo = voo;
	}

	public List<VooCordenadaAcao> getAcoes()
	{
		if(acoes == null)
		{
			acoes = new ArrayList<>();
		}
		return acoes;
	}

	public void setAcoes(List<VooCordenadaAcao> acoes)
	{
		this.acoes = acoes;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(altitude, dataRegistro, id, latitude, longitude, tenant_id, voo);
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
		VooCordenada other = (VooCordenada) obj;
		return Objects.equals(altitude, other.altitude) && Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(id, other.id) && Objects.equals(latitude, other.latitude) && Objects.equals(longitude, other.longitude) && Objects.equals(tenant_id, other.tenant_id) && Objects.equals(voo, other.voo);
	}

	@Override
	public String toString()
	{
		return "VooCoordenada [id=" + id + ", tenant_id=" + tenant_id + ", latitude=" + latitude + ", longitude=" + longitude + ", altitude=" + altitude + ", dataRegistro=" + dataRegistro + ", voo=" + voo.toString();
	}
}
