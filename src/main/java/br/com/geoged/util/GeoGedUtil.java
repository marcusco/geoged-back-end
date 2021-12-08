package br.com.geoged.util;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.inject.Singleton;
import br.com.geoged.constants.GeoGedConstants;
import br.com.geoged.enums.ErrorCodeEnum;
import br.com.geoged.enums.ExceptionCodeEnum;

@Singleton
public class GeoGedUtil {

  //

  public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy HH:mm";
  public static final String DEFAULT_BD_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

  public static String getFormatedExceptionMessage(ErrorCodeEnum code, Object... parameters) {
    String message = null;
    String key = String.format(GeoGedConstants.KEY_PREFIX, code.getCode());
    try {
      message = produceExceptionResourceBundle().getString(key);
      message = MessageFormat.format(message, parameters);
    } catch (MissingResourceException e) {
      message = MessageFormat.format(GeoGedConstants.INVALID_KEY, key);
    }
    return message;
  }

  public static String getFormatedExceptionMessage(String key, Object... parameters) {
    String message = null;
    try {
      message = produceExceptionResourceBundle().getString(key);
      message = MessageFormat.format(message, parameters);
    } catch (MissingResourceException e) {
      message = MessageFormat.format(GeoGedConstants.INVALID_KEY, key);
    }
    return message;
  }

  public static String getFormatedMessage(String key) {
    String message = null;
    try {
      message = produceMessageResourceBundle().getString(key);
    } catch (MissingResourceException e) {
      message = "???".concat(key).concat("???");
    }
    return message;
  }

  protected static ResourceBundle produceExceptionResourceBundle() {
    return produceResourceBundle(GeoGedConstants.EXCEPTION_MESSAGE);
  }

  private static ResourceBundle produceMessageResourceBundle() {
    return produceResourceBundle(GeoGedConstants.MESSAGE);
  }

  private static ResourceBundle produceResourceBundle(String baseName) {
    var locale = LocaleThreadLocal.get();
    return ResourceBundle.getBundle(baseName, locale);
  }

  public static String getExceptionKey(ExceptionCodeEnum code) {
    if (code != null) {
      return String.format(GeoGedConstants.KEY_PREFIX, code.getCode());
    }
    return null;
  }

  public static String getFormattedDate(Calendar value, String format) {
    var formatter = new SimpleDateFormat(format);
    return formatter.format(value.getTime());
  }

  public static String getBDStyleFormattedDate(Calendar value) {
    var formatter = new SimpleDateFormat(DEFAULT_BD_DATE_FORMAT);
    return formatter.format(value.getTime());
  }


}
