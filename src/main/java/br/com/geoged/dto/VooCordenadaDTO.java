package br.com.geoged.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;


public class VooCordenadaDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long				serialVersionUID	= 1L;
	private Integer							tenant_id;
	private Integer							id;
	private Integer							idExterno;
	private Integer							idVoo;
	private double								latitude;
	private double								longitude;
	private double								altitude;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Calendar							dataRegistro;
	private List<VooCordenadaAcaoDTO>	acoes;
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

	public Integer getIdVoo()
	{
		return idVoo;
	}

	public void setIdVoo(Integer idVoo)
	{
		this.idVoo = idVoo;
	}

	public double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	public double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}

	public double getAltitude()
	{
		return altitude;
	}

	public void setAltitude(double altitude)
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

	public List<VooCordenadaAcaoDTO> getAcoes()
	{
		return acoes;
	}

	public void setAcoes(List<VooCordenadaAcaoDTO> acoes)
	{
		this.acoes = acoes;
	}
}
