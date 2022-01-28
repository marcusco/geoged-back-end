package br.com.geoged.dto;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Transient;


public interface VooCordenadaAcaoMapaDTO 
{
	//
	public Integer getIdVoo();

	public Integer getIdCordenada();

	public Integer getIdAcao();
	
	public Double getLatitude();

	public Double getLongitude();
}
