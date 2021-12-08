package br.com.geoged.util;

import java.text.Normalizer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang3.RandomStringUtils;
import br.com.geoged.common.Cast;


/**
 */
public final class StrUtil {
  public static final int LEFT = 0;
  public static final int RIGHT = 1;
  public static final String LINE_SEPARATOR = System.getProperty("line.separator");
  public static final String EMPTY_STRING = "";
  //
  private static final String REGEX_FORMAT = "\\$\\{([^}]+)\\}";
  private static final Pattern PATTERN_FORMAT = Pattern.compile(REGEX_FORMAT);
  private static final char[] WITH_ACCENT =
      new char[] {'à', 'â', 'ê', 'ô', 'û', 'ã', 'õ', 'á', 'é', 'í', 'ó', 'ú', 'ç', 'ü', 'À', 'Â',
          'Ê', 'Ô', 'Û', 'Ã', 'Õ', 'Á', 'É', 'Í', 'Ó', 'Ú', 'Ç', 'Ü'};
  private static final char[] NO_ACCENT =
      new char[] {'a', 'a', 'e', 'o', 'u', 'a', 'o', 'a', 'e', 'i', 'o', 'u', 'c', 'u', 'A', 'A',
          'E', 'O', 'U', 'A', 'O', 'A', 'E', 'I', 'O', 'U', 'C', 'U'};

  private StrUtil() {}

  /**
   * Verifica se a String esta vazia ou é nula
   * 
   * @param string String
   * @return True Caso esteja vazia
   */
  public static boolean isEmpty(String string) {
    return ((string == null) || (string.trim().equals("")));
  }

  /**
   * Verifica se a String esta vazia ou é nula
   * 
   * @param string String
   * @return True Caso esteja vazia
   */
  public static boolean isEmpty(StringBuilder string) {
    return ((string == null) || (string.toString().trim().equals("")));
  }

  /**
   * Obtêm a String com toUpperCase
   * 
   * @param string String
   * @return String
   */
  public static String toUpperCase(String string) {
    if (string != null)
      return string.toUpperCase();
    else
      return null;
  }

  /**
   * Obtêm a String com toLowerCase
   * 
   * @param string String
   * @return String
   */
  public static String toLowerCase(String string) {
    if (string != null)
      return string.toLowerCase();
    else
      return null;
  }

  /**
   * Obtêm a String com trim
   * 
   * @param string String
   * @return String
   */
  public static String trim(String string) {
    if (string != null)
      return string.trim();
    else
      return null;
  }

  /**
   * Produz carácter
   * 
   * @param count Quantidade de vezes
   * @param caracter Carácter
   * @return Texto
   */
  public static String makeCaracter(int count, char caracter) {
    if (count >= 0) {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < count; i++) {
        builder.append(caracter);
      }
      return builder.toString();
    } else {
      return "";
    }
  }

  /**
   * Preenche String com carácteres
   * 
   * @param string String
   * @param caracter Carácter
   * @param amount Quantidade de carácteres
   * @param direction direção
   * @return String formatada
   */
  public static String fillWitthCaracter(String string, char caracter, int amount, int direction) {
    if (!StrUtil.isEmpty(string)) {
      if (string.length() < amount) {
        if (direction == LEFT) {
          return makeCaracter(amount - string.length(), caracter) + string;
        } else if (direction == RIGHT) {
          return string + makeCaracter(amount - string.length(), caracter);
        }
      }
    }
    return string;
  }

  private static String fillWitthSpaces(String string, int amount, int direction) {
    char caracter = ' ';
    //
    if (string.length() < amount) {
      if (direction == LEFT) {
        return makeCaracter(amount - string.length(), caracter) + string;
      } else if (direction == RIGHT) {
        return string + makeCaracter(amount - string.length(), caracter);
      }
    } else {
      string = string.substring(0, amount);
    }
    return string;
  }

  public static String fillWitthSpacesLeft(String string, int amount) {
    return fillWitthSpaces(string, amount, LEFT);
  }

  public static String fillWitthSpacesRight(String string, int amount) {
    return fillWitthSpaces(string, amount, RIGHT);
  }

  /**
   * Preenche String com carácteres à esquerda
   * 
   * @param string String
   * @param caracter Carácter
   * @param amount Quantidade de carácteres
   * @return String formatada
   */
  public static String fillWitthCaracterLeft(String string, char caracter, int amount) {
    return fillWitthCaracter(string, caracter, amount, LEFT);
  }

  /**
   * Preenche String com carácteres à direita
   * 
   * @param string String
   * @param caracter Carácter
   * @param amount Quantidade de carácteres
   * @return String formatada
   */
  public static String fillWitthCaracterRight(String string, char caracter, int amount) {
    return fillWitthCaracter(string, caracter, amount, RIGHT);
  }

  /**
   * Preenche String com carácteres à esquerda
   * 
   * @param string String
   * @param amount Quantidade de carácteres
   * @return String formatada
   */
  public static String fillWitthZerosLeft(String string, int amount) {
    return fillWitthCaracterLeft(string, '0', amount);
  }

  /**
   * Preenche String com carácteres à direita
   * 
   * @param string String
   * @param amount Quantidade de carácteres
   * @return String formatada
   */
  public static String fillWitthZerosRight(String string, int amount) {
    return fillWitthCaracterRight(string, '0', amount);
  }

  /**
   * Preenche String com carácteres à esquerda
   * 
   * @param value Valor
   * @param amount Quantidade de carácteres
   * @return String formatada
   */
  public static String fillWitthZerosLeft(int value, int amount) {
    return fillWitthZerosLeft(value + "", amount);
  }

  /**
   * Preenche String com carácteres à direita
   * 
   * @param value Valor
   * @param amount Quantidade de carácteres
   * @return String formatada
   */
  public static String fillWitthZerosRight(int value, int amount) {
    return fillWitthZerosRight(value + "", amount);
  }

  /**
   * Preenche String com carácteres à esquerda
   * 
   * @param value Valor
   * @param amount Quantidade de carácteres
   * @return String formatada
   */
  public static String fillWitthZerosLeft(long value, int amount) {
    return fillWitthZerosLeft(value + "", amount);
  }

  /**
   * Preenche String com carácteres à direita
   * 
   * @param value Valor
   * @param amount Quantidade de carácteres
   * @return String formatada
   */
  public static String fillWitthZerosRight(long value, int amount) {
    return fillWitthZerosRight(value + "", amount);
  }

  /**
   * Obtêm a primeira String não nula
   * 
   * @param strings Strings
   * @return String não nula
   */
  public static String coalesce(String... strings) {
    for (String string : strings) {
      if (string != null) {
        return string;
      }
    }
    return null;
  }

  /**
   * Obtêm null caso a string esteja vazia
   * 
   * @param string String
   * @return Resultado
   */
  public static String emptyToNull(String string) {
    if ((string != null) && (string.trim().equals(""))) {
      return null;
    } else {
      return string;
    }
  }

  /**
   * Obtêm uma string vazia caso a string esteja nula
   * 
   * @param string String
   * @return Resultado
   */
  public static String nullToEmpty(String string) {
    if ((string == null) || (string.trim().equals(""))) {
      return "";
    } else {
      return string;
    }
  }

  /**
   * Obtêm uma string vazia caso a string esteja nula
   * 
   * @param object toString do objeto
   * @return Resultado
   */
  public static String nullToEmpty(Object object) {
    if (object != null) {
      String toString = object.toString();
      //
      return nullToEmpty(toString);
    } else {
      return nullToEmpty((String) null);
    }
  }

  public static String nullToValue(String string, String value) {
    if (string == null) {
      return value;
    } else if (string.trim().equals("")) {
      return "";
    } else {
      return string;
    }
  }

  public static String nullToEmpty(Integer value) {
    if (value == null) {
      return "";
    } else {
      return value.toString();
    }
  }

  /**
   * Obtêm o indice da string no vetor
   * 
   * @param source String a ser localizada
   * @param strings Vetor de String
   * @return -1 caso não encontre
   */
  public static int ansiIndexStr(String source, List<String> strings) {
    if (!CollectionsUtil.isEmpty(strings)) {
      for (int i = 0; i < strings.size(); i++) {
        if (nullToEmpty(source).equals(strings.get(i))) {
          return i;
        }
      }
    }
    return -1;
  }

  /**
   * Obtêm o indice da string no vetor
   * 
   * @param source String a ser localizada
   * @param strings Vetor de String
   * @return -1 caso não encontre
   */
  public static int ansiIndexStr(String source, String... strings) {
    for (int i = 0; i < strings.length; i++) {
      if (nullToEmpty(source).equals(strings[i])) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Remove acentos de uma String
   * 
   * @param str String
   * @return String sem acentos
   */
  public static String removeAccents(String str) {
    if (!isEmpty(str)) {
      str = Normalizer.normalize(str, Normalizer.Form.NFD);
      str = str.replaceAll("[^\\p{ASCII}]", "");
    }
    //
    return str;
  }

  public static String trimAndToUpperCaseAndRemoveAccents(String str) {
    return trim(toUpperCase(removeAccents(str)));
  }

  public static String trimAndToLowerCaseAndRemoveAccents(String str) {
    return trim(toLowerCase(removeAccents(str)));
  }

  public static String unaccent(String str) {
    if (!isEmpty(str)) {
      StringBuilder builder = new StringBuilder();
      //
      for (int i = 0; i < str.length(); i++) {
        int indexAccent = -1;
        //
        for (int j = 0; j < WITH_ACCENT.length; j++) {
          if (str.charAt(i) == WITH_ACCENT[j]) {
            indexAccent = j;
            //
            break;
          }
        }
        //
        if (indexAccent != -1) {
          builder.append(NO_ACCENT[indexAccent]);
        } else {
          builder.append(str.charAt(i));
        }
      }
      //
      return builder.toString();
    } else {
      return str;
    }
  }

  public static int length(String string) {
    if (!StrUtil.isEmpty(string)) {
      return string.length();
    } else {
      return 0;
    }
  }

  public static int size(String string) {
    return length(string);
  }

  /**
   * Retorna apenas os números da string passada no parâmetro. equivale a expressão regular [0-9]
   * 
   * @param key
   * @return String com números
   */
  public static boolean isOnlyNumbers(String text) {
    if (text == null)
      return false;
    return !text.matches("[^0-9]*");
  }

  public static String onlyNumber(String str) {
    if (str != null) {
      return str.replaceAll("[^0123456789]", "");
    } else {
      return "";
    }
  }

  public static String limitStringWithDots(String string, int caracters) {
    if (!isEmpty(string)) {
      if (string.length() > caracters) {
        string = string.substring(0, caracters - 3) + "...";
      }
    }
    //
    return string;
  }

  public static String limitString(String string, int caracters) {
    if (!isEmpty(string)) {
      if (string.length() > caracters) {
        return string.substring(0, caracters);
      } else {
        return string;
      }
    } else {
      return null;
    }
  }

  public static String stringToASCII(String value, char escape) {
    StringBuilder builder = new StringBuilder();
    //
    for (int i = 0; i < StrUtil.nullToEmpty(value).length(); i++) {
      builder.append((int) value.charAt(i));
      //
      if (i < StrUtil.nullToEmpty(value).length() - 1) {
        builder.append(escape);
      }
    }
    //
    return builder.toString();
  }

  public static String asciiToString(String value, char escape) {
    StringBuilder builder = new StringBuilder();
    //
    if (!StrUtil.isEmpty(value)) {
      String[] tmp = value.split("\\" + escape);
      //
      for (int i = 0; i < tmp.length; i++) {
        Cast cast = new Cast(tmp[i]);
        builder.append((char) cast.toInteger().intValue());
      }
    }
    //
    return builder.toString();
  }

  public static String replaceAllFromMap(String text, Map<String, String> map) {
    //
    String textTmp = text;
    //
    if ((!isEmpty(text)) && ((map != null) && (map.size() > 0))) {
      //
      for (Map.Entry<String, String> entry : map.entrySet()) {
        //
        try {
          //
          textTmp = textTmp.replace(entry.getKey(), entry.getValue());
        } catch (Exception e) {
          //
          e.printStackTrace();;
        }
      }
    }
    //
    return textTmp;
  }

  public static boolean in(String source, String... values) {
    boolean result = false;
    //
    for (String value : values) {
      if (((source == null) && (value == null)) || ((source != null) && (source.equals(value)))) {
        result = true;
        //
        break;
      }
    }
    //
    return result;
  }

  public static String generateSequentialName(List<String> listName, String fileName, int value) {
    //
    String fileNameFormat = "%s (%d)";
    //
    String nameTmp = String.format(fileNameFormat, fileName, value);
    //
    if (listName != null) {
      //
      if (listName.contains(nameTmp)) {
        //
        int newValue = ++value;
        //
        return generateSequentialName(listName, fileName, newValue);
      } else {
        //
        return nameTmp;
      }
    } else {
      //
      return nameTmp;
    }
  }

  public static String generateSequentialFileName(List<String> listName, String fileName,
      String extension, int value) {
    //
    String nameTmp = null;
    //
    if (fileName.contains("%02d")) {
      //
      nameTmp = String.format(fileName, value);
    } else {
      //
      nameTmp = ((fileName != null) ? fileName : "") + ((extension != null) ? extension : "");
    }
    //
    if (listName != null) {
      //
      if (listName.contains(nameTmp)) {
        //
        int newValue = ++value;
        //
        return generateSequentialFileName(listName,
            (fileName.contains("%02d") ? fileName : fileName + "(%02d)" + extension), "", newValue);
      } else {
        //
        return nameTmp;
      }
    } else {
      //
      return nameTmp;
    }
  }

  public static String toUpperCaseFirst(String string) {
    if (!isEmpty(string)) {
      return string.substring(0, 1).toUpperCase()
          + string.substring(1, string.length()).toLowerCase();
    } else {
      return string;
    }
  }

  public static String toCapitalize(String string) {
    if (!isEmpty(string)) {
      char[] array = string.toCharArray();
      //
      array[0] = Character.toUpperCase(array[0]);
      //
      for (int i = 1; i < array.length; i++) {
        if (Character.isWhitespace(array[i - 1])) {
          array[i] = Character.toUpperCase(array[i]);
        } else if (!Character.isWhitespace(array[i])) {
          array[i] = Character.toLowerCase(array[i]);
        }
      }
      //
      return new String(array);
    }
    //
    return string;
  }

  public static boolean equals(String string, String stringCompare) {
    if ((string == null) && (stringCompare == null)) {
      return true;
    } else if ((string != null) && (stringCompare != null)) {
      return string.equals(stringCompare);
    } else {
      return false;
    }
  }

  public static String getString(String[] strings, String separator, Integer positionStart,
      Integer positionFinal) {
    if ((strings != null) && (positionFinal >= positionStart)) {
      StringBuilder result = new StringBuilder();
      //
      if (strings.length > positionStart) {
        for (int i = positionStart; i <= positionFinal; i++) {
          if (i != positionStart) {
            result.append(nullToEmpty(separator));
          }
          //
          result.append(strings[i]);
        }
      }
      //
      return result.toString();
    } else {
      return null;
    }
  }

  public static String getString(String[] strings, String separator, Integer[] positions) {
    if (strings != null) {
      StringBuilder result = new StringBuilder();
      //
      if (strings.length > 0) {
        for (Integer position : positions) {
          if (position < strings.length) {
            if (position != positions[0]) {
              result.append(nullToEmpty(separator));
            }
            //
            result.append(strings[position]);
          }
        }
      }
      //
      return result.toString();
    } else {
      return null;
    }
  }

  public static String sqlIn(Collection<?> values) {
    if (!CollectionsUtil.isEmpty(values)) {
      Iterator<?> iterator = values.iterator();
      //
      while (iterator.hasNext()) {
        Object object = iterator.next();
        //
        if (object != null) {
          if (object.getClass().isAssignableFrom(String.class)) {
            return sqlIn(values.toArray(new String[values.size()]));
          } else if (object.getClass().isAssignableFrom(Integer.class)) {
            return sqlIn(values.toArray(new Integer[values.size()]));
          }
        }
      }
    }
    //
    return null;
  }

  public static String sqlIn(Integer... integers) {
    if ((!CollectionsUtil.isEmpty(integers)) && (integers[0] != null)) {
      StringBuilder result = new StringBuilder();
      //
      for (int i = 0; i < integers.length; i++) {
        if (i > 0) {
          result.append(", ");
        }
        //
        result.append(integers[i]);
      }
      //
      return result.toString();
    } else {
      return null;
    }
  }

  public static String sqlIn(String... strings) {
    if ((!CollectionsUtil.isEmpty(strings)) && (!isEmpty(strings[0]))) {
      StringBuilder result = new StringBuilder();
      //
      for (int i = 0; i < strings.length; i++) {
        if (i > 0) {
          result.append(", ");
        }
        //
        result.append("'" + strings[i] + "'");
      }
      //
      return result.toString();
    } else {
      return null;
    }
  }

  public static String quotes(String string, boolean trim) {
    if (string != null) {
      return "'" + (trim ? string.trim() : string) + "'";
    } else {
      return string;
    }
  }

  public static String quotes(String string) {
    return quotes(string, false);
  }

  public static String doubleQuotes(String string, boolean trim) {
    if (string != null) {
      return "\"" + (trim ? string.trim() : string) + "\"";
    } else {
      return string;
    }
  }

  public static String doubleQuotes(String string) {
    return doubleQuotes(string, false);
  }

  public static String generateRandomString(Integer count, Boolean letters, Boolean numbers) {
    //
    return RandomStringUtils.random(count, letters, numbers);
  }

  public static String generateRandomString(Integer countGroup, Integer countSubGroup,
      String separator, Boolean letters, Boolean numbers) {
    //
    StringBuilder randomTmp = new StringBuilder();
    //
    for (int i = 0; i < countGroup; i++) {
      //
      randomTmp.append(generateRandomString(countSubGroup, letters, numbers).concat(separator));
    }
    //
    return randomTmp.substring(0, (randomTmp.length() - 1));
  }

}
