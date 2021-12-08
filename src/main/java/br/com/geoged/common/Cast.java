package br.com.geoged.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Classe responsável por verificar tipo do objeto e fazer as conversões
 * 
 * @author Leonardo Chain
 * 
 * @version 1.00
 * 
 * @since 1.00
 */
public class Cast implements Serializable {
  private static final long serialVersionUID = 1L;
  //
  private Object object = null;

  public Cast(Object object) {
    this.object = object;
  }

  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }

  public boolean isNull() {
    return (object == null);
  }

  public boolean isString() {
    return (object instanceof String);
  }

  public boolean isDate() {
    return ((object instanceof Date) || (object instanceof Calendar)
        || (object instanceof Timestamp) || (object instanceof GregorianCalendar));
  }

  public boolean isDouble() {
    return ((object instanceof BigDecimal) || (object instanceof Double) || (isInteger()));
  }

  public boolean isInteger() {
    return ((object instanceof Integer) || (object instanceof Long)
        || (object instanceof BigInteger));
  }

  public boolean isBoolean() {
    return (object instanceof Boolean);
  }

  public Integer toInteger() {
    if (object != null) {
      if (isInteger()) {
        if (object instanceof Integer) {
          return (Integer) object;
        }
        //
        if (object instanceof Long) {
          return ((Long) object).intValue();
        }
        //
        if (object instanceof BigInteger) {
          return ((BigInteger) object).intValue();
        }
      }
      //
      return Integer.parseInt(object.toString());
    } else {
      return null;
    }
  }

  public Integer toIntegerToDef(Integer valueDefault) {
    try {
      return toInteger();
    } catch (NumberFormatException e) {
      return valueDefault;
    }
  }

  public BigInteger toBigInteger() {
    if (object != null) {
      return new BigInteger(toInteger().toString());
    } else {
      return null;
    }
  }

  public BigInteger toBigIntegerToDef(BigInteger valueDefault) {
    try {
      return toBigInteger();
    } catch (NumberFormatException e) {
      return valueDefault;
    }
  }

  public Date toDate() {
    if (object instanceof Timestamp) {
      return new Date(((Timestamp) object).getTime());
    }
    //
    if (object instanceof Date) {
      return ((Date) object);
    }
    //
    if (object instanceof Calendar) {
      return ((Calendar) object).getTime();
    }
    //
    if (object instanceof GregorianCalendar) {
      return ((GregorianCalendar) object).getTime();
    } else {
      return null;
    }
  }

  public GregorianCalendar toGregorianCalendar() {
    GregorianCalendar calendar = null;
    //
    if (object instanceof Timestamp) {
      calendar = new GregorianCalendar();
      calendar.setTime((Timestamp) object);
      return calendar;
    }
    //
    if (object instanceof Date) {
      calendar = new GregorianCalendar();
      calendar.setTime((Date) object);
      return calendar;
    }
    //
    if (object instanceof Calendar) {
      calendar = new GregorianCalendar();
      calendar.setTime(((Calendar) object).getTime());
      return calendar;
    }
    //
    if (object instanceof GregorianCalendar) {
      return ((GregorianCalendar) object);
    } else {
      return null;
    }
  }

  public Double toDouble() {
    if (object != null) {
      if (isInteger()) {
        return new Double(toInteger());
      }
      //
      if (isDouble()) {
        if (object instanceof Double) {
          return (Double) object;
        }
        //
        if (object instanceof BigDecimal) {
          return ((BigDecimal) object).doubleValue();
        }
      }
      //
      return Double.parseDouble(object.toString());
    } else {
      return null;
    }
  }

  public Double toDoubleToDef(Double valueDefault) {
    try {
      return toDouble();
    } catch (NumberFormatException e) {
      return valueDefault;
    }
  }

  public BigDecimal toBigDecimal() {
    if (object != null) {
      return new BigDecimal(toDouble());
    } else {
      return null;
    }
  }

  public BigDecimal toBigDecimalToDef(BigDecimal valueDefault) {
    try {
      return toBigDecimal();
    } catch (NumberFormatException e) {
      return valueDefault;
    }
  }

  public Boolean toBoolean() {
    if (isBoolean()) {
      return ((Boolean) object);
    } else {
      return null;
    }
  }

  @Override
  public String toString() {
    String s = null;
    //
    if (object != null) {
      s = object.toString();
    }
    //
    return s;
  }
}
