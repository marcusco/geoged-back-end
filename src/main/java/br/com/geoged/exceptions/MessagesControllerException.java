package br.com.geoged.exceptions;

public class MessagesControllerException extends GeoGedException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  public MessagesControllerException(String error) {
    super("messages.controller.exception" + error);
  }

}
