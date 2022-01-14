package br.com.geoged.dto;

import java.io.Serializable;
import java.util.Calendar;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import br.com.geoged.gson.util.CustomDateDeserializer;


public class VooCordenadaAcaoDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private Integer				tenant_id;
	private Integer				id;
	private Integer				idExterno;
	private Integer				idAcaoTipo;
	private Integer				idVooCordenada;
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Calendar				dataRegistro;
	private String					valorClob;
	private byte[]					valorBlob;
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

	public Integer getIdAcaoTipo()
	{
		return idAcaoTipo;
	}

	public void setIdAcaoTipo(Integer idAcaoTipo)
	{
		this.idAcaoTipo = idAcaoTipo;
	}

	public Integer getIdVooCordenada()
	{
		return idVooCordenada;
	}

	public void setIdVooCordenada(Integer idVooCordenada)
	{
		this.idVooCordenada = idVooCordenada;
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
}
