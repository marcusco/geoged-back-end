package br.com.geoged.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import br.com.geoged.util.SchemaUtil;

@Entity
@Table(name = "colaborador", schema = SchemaUtil.DEFAULT,
    uniqueConstraints = @UniqueConstraint(columnNames = {"tenant_id", "nome", "cpfcnpj"}))
public class Colaborador implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = SchemaUtil.DEFAULT + ".seq_colaborador")
  @Column(name = "id", nullable = false)
  private Integer id;
  @Column(name = "tenant_id")
  private Integer tenantId;
  @Column(name = "nome", length = 255)
  private String nome;
  @Column(name = "cpfcnpj", length = 255)
  private String cpfCnpj;



  public Colaborador() {
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

  public String getCpfCnpj() {
    return cpfCnpj;
  }

  public void setCpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpfCnpj, id, nome, tenantId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Colaborador other = (Colaborador) obj;
    return Objects.equals(cpfCnpj, other.cpfCnpj) && Objects.equals(id, other.id)
        && Objects.equals(nome, other.nome) && Objects.equals(tenantId, other.tenantId);
  }

  @Override
  public String toString() {
    return "Colaborador [id=" + id + ", tenantId=" + tenantId + ", nome=" + nome + ", cpfCnpj="
        + cpfCnpj + "]";
  }



}