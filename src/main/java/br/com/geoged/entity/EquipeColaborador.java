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
@Table(name = "equipecolaborador", schema = SchemaUtil.DEFAULT, uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tenant_id", "idcolaborador", "idequipe"})})
public class EquipeColaborador implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = SchemaUtil.DEFAULT + ".seq_equipe")
  @Column(name = "id", nullable = false)
  private Integer id;
  @Column(name = "tenant_id")
  private Integer tenantId;
  @Column(name = "nome", length = 255, nullable = false)
  private String nome;
  @JoinColumn(name = "idcolaborador", referencedColumnName = "id")
  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
  private Colaborador colaborador;
  @JoinColumn(name = "idequipe", referencedColumnName = "id")
  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
  private Equipe equipe;


  public EquipeColaborador() {
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

  public Colaborador getColaborador() {
    return colaborador;
  }

  public void setColaborador(Colaborador colaborador) {
    this.colaborador = colaborador;
  }

  public Equipe getEquipe() {
    return equipe;
  }

  public void setEquipe(Equipe equipe) {
    this.equipe = equipe;
  }

  @Override
  public int hashCode() {
    return Objects.hash(colaborador, equipe, id, nome, tenantId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    EquipeColaborador other = (EquipeColaborador) obj;
    return Objects.equals(colaborador, other.colaborador) && Objects.equals(equipe, other.equipe)
        && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
        && Objects.equals(tenantId, other.tenantId);
  }

  @Override
  public String toString() {
    return "EquipeColaborador [id=" + id + ", tenantId=" + tenantId + ", nome=" + nome
        + ", colaborador=" + colaborador + ", equipe=" + equipe + "]";
  }
}
