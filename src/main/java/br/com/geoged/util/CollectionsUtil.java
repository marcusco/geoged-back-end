package br.com.geoged.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;


/**
 * Classe utilitária para o uso de Collections
 * 
 * @author Leonardo Chain
 * 
 * @version 1.00
 * 
 * @since 1.00
 */
public final class CollectionsUtil {
  private CollectionsUtil() {}

  /**
   * Verifica se o Map esta vazio ou é nulo
   * 
   * @param map Map
   * @return True Caso esteja vazio
   */
  public static boolean isEmpty(Map<?, ?> map) {
    return ((map == null) || (map.isEmpty()));
  }

  /**
   * Verifica se a Collection esta vazia ou é nula
   * 
   * @param collection Collection
   * @return True Caso esteja vazia
   */
  public static boolean isEmpty(Collection<?> collection) {
    return ((collection == null) || (collection.size() == 0));
  }

  public static boolean isEmpty(Object[] args) {
    return ((args == null) || (args.length == 0));
  }

  /**
   * Obtêm a quantidade de elementos em uma Collection
   * 
   * @param collection Collection
   * @return Quantidade de elementos
   */
  public static int size(Collection<?> collection) {
    if (collection != null) {
      return collection.size();
    } else {
      return 0;
    }
  }

  public static int size(Object[] args) {
    if (args != null) {
      return args.length;
    } else {
      return 0;
    }
  }

  @SuppressWarnings("unchecked")
  public static <A extends Object> A get(Collection<?> collection, int position) {
    if (size(collection) > position) {
      return (A) collection.toArray()[position];
    } else {
      return null;
    }
  }

  public static <A extends Object> A get(A[] args, int position) {
    if (size(args) > position) {
      return args[position];
    } else {
      return null;
    }
  }

  @SuppressWarnings("unchecked")
  public static <A extends Object> A getByDefault(Collection<?> collection, int position,
      A valueDefault) {
    if (size(collection) > position) {
      return (A) collection.toArray()[position];
    } else {
      return valueDefault;
    }
  }

  public static <A extends Object> A getByDefault(A[] args, int position, A valueDefault) {
    if (size(args) > position) {
      return args[position];
    } else {
      return valueDefault;
    }
  }

  @SuppressWarnings("unchecked")
  public static <A extends Object> A remove(List<?> list, int position) {
    if ((position >= 0) && (size(list) > position)) {
      return (A) list.remove(position);
    } else {
      return null;
    }
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  public static List toList(Enumeration enumeration) {
    return Collections.list(enumeration);
  }

  public static boolean exists(Object[] values, Object value) {
    if (values != null) {
      for (Object object : values) {
        if (((value == null) && (object == null)) || ((value != null) && (value.equals(object)))) {
          return true;
        }
      }
    }
    //
    return false;
  }

  public static List<?> moveBack(List<?> list, int indexOrigin) {
    if (list != null) {
      if (indexOrigin > 0) {
        Collections.swap(list, indexOrigin, indexOrigin - 1);
      }
    }
    //
    return list;
  }

  public static List<?> moveBack(List<?> list, Object object) {
    if ((list != null) && (object != null)) {
      int index = list.indexOf(object);
      //
      moveBack(list, index);
    }
    //
    return list;
  }

  public static List<?> moveForward(List<?> list, int indexOrigin) {
    if (list != null) {
      if (indexOrigin < (list.size() - 1)) {
        Collections.swap(list, indexOrigin, indexOrigin + 1);
      }
    }
    //
    return list;
  }

  public static List<?> moveForward(List<?> list, Object object) {
    if ((list != null) && (object != null)) {
      int index = list.indexOf(object);
      //
      moveForward(list, index);
    }
    //
    return list;
  }

  public static <T> int indexOf(T[] a, T target) {
    for (int i = 0; i < a.length; i++) {
      if (target.equals(a[i])) {
        return i;
      }
      //
    }
    return -1;
  }

  public static <T> List<T> addAll(List<T> origin, List<T> data) {
    List<T> result = origin;
    //
    if (result == null) {
      result = new ArrayList<T>();
    }
    //
    if (!CollectionsUtil.isEmpty(data)) {
      result.addAll(data);
    }
    //
    return result;
  }

  @SuppressWarnings("unchecked")
  public static <A extends Object> A first(Collection<?> collection) {
    if (!isEmpty(collection)) {
      return (A) collection.toArray()[0];
    } else {
      return null;
    }
  }

  public static <A extends Object> A first(A[] args) {
    if (!isEmpty(args)) {
      return args[0];
    } else {
      return null;
    }
  }

  @SuppressWarnings("unchecked")
  public static <A extends Object> A last(Collection<?> collection) {
    if (!isEmpty(collection)) {
      return (A) collection.toArray()[size(collection) - 1];
    } else {
      return null;
    }
  }

  public static <A extends Object> A last(A[] args) {
    if (!isEmpty(args)) {
      return args[size(args) - 1];
    } else {
      return null;
    }
  }

  public static List<Integer> convert2ListInteger(List<String> list) {
    //
    List<Integer> listTmp = new ArrayList<Integer>();
    //
    if (!isEmpty(list)) {
      //
      for (String tmp : list) {
        //
        try {
          //
          listTmp.add(Integer.valueOf(tmp.trim()));
        } catch (Exception ex) {
          //
        }
      }
    }
    //
    return listTmp;
  }
}
