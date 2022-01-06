package br.com.geoged.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;


public class VooDTO implements Serializable
{
	/**
	* 
	*/
	private static final long		serialVersionUID	= 1L;
	private Integer					tenant_id;
	private Integer					id;
	private Integer					idExterno;
	private Integer					idUsuario;
	private Integer					idEquipe;
	private Integer					idEquipamento;
	private String						nome;
	private String						descricao;
	private Calendar					dataRegistro;
	private List<VooCordenadaDTO>	cordenadas;
	//
	public Integer getTenant_id()
	{
		return tenant_id;
	}

	public void setTenant_id(Integer tenant_id)
	{
		this.tenant_id = tenant_id;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
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

	public Integer getIdUsuario()
	{
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario)
	{
		this.idUsuario = idUsuario;
	}

	public Integer getIdEquipe()
	{
		return idEquipe;
	}

	public void setIdEquipe(Integer idEquipe)
	{
		this.idEquipe = idEquipe;
	}

	public Integer getIdEquipamento()
	{
		return idEquipamento;
	}

	public void setIdEquipamento(Integer idEquipamento)
	{
		this.idEquipamento = idEquipamento;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
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

	public List<VooCordenadaDTO> getCordenadas()
	{
		return cordenadas;
	}

	public void setCordenadas(List<VooCordenadaDTO> cordenadas)
	{
		this.cordenadas = cordenadas;
	}
}
