package br.com.geoged.enums;

import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;


public enum AcaoTipoEnum
{
	@JsonProperty("0")
	FOTO(0, "foto"), @JsonProperty("1")
	FILME(1, "filme");
	private Integer	codigo		= null;
	private String		descricao	= null;
	private AcaoTipoEnum(Integer codigo, String descricao)
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

	public static AcaoTipoEnum getEnum(Integer codigo)
	{
		if(codigo != null)
		{
			switch(codigo)
			{
				case 0:
					return FOTO;
				case 1:
					return FILME;
				default:
					return null;
			}
		}
		//
		return null;
	}

	public static List<AcaoTipoEnum> toList()
	{
		return Arrays.asList(AcaoTipoEnum.values());
	}

	@Override
	public String toString()
	{
		return descricao;
	}
}
