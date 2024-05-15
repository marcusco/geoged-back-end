package br.com.geoged.exceptions;

public class TenantIdExistsException extends GeoGedException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  public TenantIdExistsException() {
    super("tenantid.exists.exception");
  }

}
