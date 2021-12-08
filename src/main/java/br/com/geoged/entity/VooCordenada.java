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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import br.com.geoged.util.SchemaUtil;

@Entity
@Table(name = "voocordenada", schema = SchemaUtil.DEFAULT)
public class VooCordenada implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = SchemaUtil.DEFAULT + ".seq_voocordenada")
  @Column(name = "id", nullable = false)
  private Integer id;
  @Column(name = "tenant_id", nullable = false)
  private Integer tenantId;
  @Column(name = "latitude", nullable = false, columnDefinition = "double precision")
  private Double latitude;
  @Column(name = "longitude", nullable = false, columnDefinition = "double precision")
  private Double longitude;
  @Column(name = "altitude", nullable = false, columnDefinition = "double precision")
  private Double altitude;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "dataregistro", nullable = false)
  private Calendar dataRegistro;
  @JoinColumn(name = "idvoo", referencedColumnName = "id")
  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
  private Voo voo;
  @JoinColumn(name = "idvoocordenadaacao", referencedColumnName = "id")
  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
  private VooCordenadaAcao vooCoordenadaAcao;

  @Transient
  private List<VooCordenadaAcao> acoes = null;

  public VooCordenada() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getTenantId() {
    return tenantId;
  }

  public void setTenantId(Integer tenantId) {
    this.tenantId = tenantId;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Double getAltitude() {
    return altitude;
  }

  public void setAltitude(Double altitude) {
    this.altitude = altitude;
  }

  public Calendar getDataRegistro() {
    return dataRegistro;
  }

  public void setDataRegistro(Calendar dataRegistro) {
    this.dataRegistro = dataRegistro;
  }

  public Voo getVoo() {
    return voo;
  }

  public void setVoo(Voo voo) {
    this.voo = voo;
  }

  public VooCordenadaAcao getVooCoordenadaAcao() {
    return vooCoordenadaAcao;
  }

  public void setVooCoordenadaAcao(VooCordenadaAcao vooCoordenadaAcao) {
    this.vooCoordenadaAcao = vooCoordenadaAcao;
  }



  public List<VooCordenadaAcao> getAcoes() {
    if (acoes == null) {
      acoes = new ArrayList<>();
    }
    return acoes;
  }

  public void setAcoes(List<VooCordenadaAcao> acoes) {
    this.acoes = acoes;
  }

  @Override
  public int hashCode() {
    return Objects.hash(altitude, dataRegistro, id, latitude, longitude, tenantId, voo,
        vooCoordenadaAcao);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    VooCordenada other = (VooCordenada) obj;
    return Objects.equals(altitude, other.altitude)
        && Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(id, other.id)
        && Objects.equals(latitude, other.latitude) && Objects.equals(longitude, other.longitude)
        && Objects.equals(tenantId, other.tenantId) && Objects.equals(voo, other.voo)
        && Objects.equals(vooCoordenadaAcao, other.vooCoordenadaAcao);
  }

  @Override
  public String toString() {
    return "VooCoordenada [id=" + id + ", tenantId=" + tenantId + ", latitude=" + latitude
        + ", longitude=" + longitude + ", altitude=" + altitude + ", dataRegistro=" + dataRegistro
        + ", voo=" + voo + ", vooCoordenadaAcao=" + vooCoordenadaAcao + "]";
  }
}
