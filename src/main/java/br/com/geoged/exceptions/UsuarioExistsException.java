package br.com.geoged.exceptions;

public class UsuarioExistsException extends GeoGedException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  public UsuarioExistsException() {
    super("usuario.exists.exception");
  }

}
