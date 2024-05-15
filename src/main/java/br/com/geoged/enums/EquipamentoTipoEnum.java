package br.com.geoged.enums;

import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;


public enum EquipamentoTipoEnum
{
	@JsonProperty("0")
	DRONE(0, "drone"), @JsonProperty("1")
	CAMERA_FOTOGRAFICA(1, "camera_fotografica");
	private Integer	codigo		= null;
	private String		descricao	= null;
	private EquipamentoTipoEnum(Integer codigo, String descricao)
	{
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo()
	{
		return codigo;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public static EquipamentoTipoEnum getEnum(Integer codigo)
	{
		if(codigo != null)
		{
			switch(codigo)
			{
				case 0:
					return DRONE;
				case 1:
					return CAMERA_FOTOGRAFICA;
				default:
					return null;
			}
		}
		//
		return null;
	}

	public static List<EquipamentoTipoEnum> toList()
	{
		return Arrays.asList(EquipamentoTipoEnum.values());
	}

	@Override
	public String toString()
	{
		return descricao;
	}
}
