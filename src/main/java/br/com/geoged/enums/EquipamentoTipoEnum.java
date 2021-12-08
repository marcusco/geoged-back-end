package br.com.geoged.enums;

import java.util.Arrays;
import java.util.List;

public enum EquipamentoTipoEnum {
  DRONE(0, "drone"), CAMERA_FOTOGRAFICA(1, "camera_fotografica");

  private Integer codigo = null;
  private String descricao = null;

  private EquipamentoTipoEnum(Integer codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public static EquipamentoTipoEnum getEnum(Integer codigo) {
    if (codigo != null) {
      switch (codigo) {
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

  public static List<EquipamentoTipoEnum> toList() {
    return Arrays.asList(EquipamentoTipoEnum.values());
  }

  @Override
  public String toString() {
    return descricao;
  }


}
