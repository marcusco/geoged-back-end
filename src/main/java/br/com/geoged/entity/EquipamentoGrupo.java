package br.com.geoged.entity;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import br.com.geoged.util.SchemaUtil;

@Entity
@Table(name = "equipamentogrupo", schema = SchemaUtil.DEFAULT,
    uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id", "nome"}),
        @UniqueConstraint(columnNames = {"tenant_id", "idequipamento"})})
public class EquipamentoGrupo implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = SchemaUtil.DEFAULT + ".seq_equipamentogrupo")
  @Column(name = "id", nullable = false)
  private Integer id;
  @Column(name = "tenant_id")
  private Integer tenantId;
  @Column(name = "nome", length = 255, nullable = false)
  private String nome;
  @JoinColumn(name = "idequipamento", referencedColumnName = "id")
  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
  private Equipamento equipamento;



  public EquipamentoGrupo() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getTenantId() {
    return tenantId;
  }

  public void setTenantId(Integer tenantId) {
    this.tenantId = tenantId;
  }

  public Equipamento getEquipamento() {
    return equipamento;
  }

  public void setEquipamento(Equipamento equipamento) {
    this.equipamento = equipamento;
  }

  @Override
  public int hashCode() {
    return Objects.hash(equipamento, id, nome, tenantId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    EquipamentoGrupo other = (EquipamentoGrupo) obj;
    return Objects.equals(equipamento, other.equipamento) && Objects.equals(id, other.id)
        && Objects.equals(nome, other.nome) && Objects.equals(tenantId, other.tenantId);
  }

  @Override
  public String toString() {
    return "EquipamentoGrupo [id=" + id + ", tenantId=" + tenantId + ", nome=" + nome
        + ", equipamento=" + equipamento + "]";
  }
}
