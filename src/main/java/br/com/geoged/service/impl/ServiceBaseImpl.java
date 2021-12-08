package br.com.geoged.service.impl;

import java.util.ArrayList;
import java.util.List;
import br.com.geoged.exceptions.GeoGedException;

public abstract class ServiceBaseImpl<T> {

  protected List<String> messagesError = new ArrayList<>();

  protected void posSave(T entity) throws GeoGedException {};

  protected void preSave(T entity) throws GeoGedException {};

  protected void preDelete(T entity) throws GeoGedException {};

  public List<String> getMessagesError() {
    return messagesError;
  }

}
