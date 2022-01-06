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
@Table(name = "voo", schema = SchemaUtil.DEFAULT, uniqueConstraints = @UniqueConstraint(columnNames = {"tenant_id",
		"nome", "dataregistro"}))
public class Voo extends EntityBase implements Serializable
{
	/**
	* 
	*/
	private static final long	serialVersionUID	= 1L;
	@Id
	@SequenceGenerator(name = "VOO_GENERATOR", sequenceName = SchemaUtil.DEFAULT + ".seq_voo", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOO_GENERATOR")
	@Column(name = "id", nullable = false)
	private Integer				id;
	@Column(name = "tenant_id")
	private Integer				tenant_id;
	@Column(name = "nome", length = 255, nullable = false)
	private String					nome;
	@Column(name = "descricao", length = 255)
	private String					descricao;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataregistro", nullable = false)
	private Calendar				dataRegistro;
	@JoinColumn(name = "idusuario", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Usuario				usuario;
	@JoinColumn(name = "idequipe", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Equipe					equipe;
	@JoinColumn(name = "idequipamento", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Equipamento			equipamento;
	@Transient
	private Integer				idExterno;
	@Transient
	private List<VooCordenada>	cordenadas			= null;
	public Voo()
	{
		super();
		cordenadas = new ArrayList<>();
	}

	public Voo(Integer id)
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

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Integer getTenant_id()
	{
		return tenant_id;
	}

	public void setTenant_id(Integer tenant_id)
	{
		this.tenant_id = tenant_id;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public Calendar getDataRegistro()
	{
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro)
	{
		this.dataRegistro = dataRegistro;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public Equipe getEquipe()
	{
		return equipe;
	}

	public void setEquipe(Equipe equipe)
	{
		this.equipe = equipe;
	}

	public Equipamento getEquipamento()
	{
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento)
	{
		this.equipamento = equipamento;
	}

	public List<VooCordenada> getCordenadas()
	{
		return cordenadas;
	}

	public void setCordenadas(List<VooCordenada> cordenadas)
	{
		this.cordenadas = cordenadas;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(dataRegistro, descricao, equipamento, equipe, id, nome, tenant_id, usuario);
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
		Voo other = (Voo) obj;
		return Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(descricao, other.descricao) && Objects.equals(equipamento, other.equipamento) && Objects.equals(equipe, other.equipe) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(tenant_id, other.tenant_id) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString()
	{
		return "Voo [id=" + id + ", tenant_id=" + tenant_id + ", nome=" + nome + ", descricao=" + descricao + ", dataRegistro=" + dataRegistro + ", usuario=" + usuario + ", equipe=" + equipe + ", equipamento=" + equipamento + "]";
	}
}
