package com.o2oweb.common.dao.support;
/**
 * @author 作者姓名 king
 * @version 创建时间：Feb 25, 2013 11:36:05 AM
 * 类说明
 */
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GenericsUtils
{
  private static final Log log = LogFactory.getLog(GenericsUtils.class);

  public static Class getSuperClassGenricType(Class clazz)
  {
    return getSuperClassGenricType(clazz, 0);
  }

  public static Class getSuperClassGenricType(Class clazz, int index)
  {
    Type genType = clazz.getGenericSuperclass();

    if (!(genType instanceof ParameterizedType)) {
      log.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
      return Object.class;
    }

    Type[] params = ((ParameterizedType)genType).getActualTypeArguments();

    if ((index >= params.length) || (index < 0)) {
      log.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + 
        params.length);
      return Object.class;
    }
    if (!(params[index] instanceof Class)) {
      log.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
      return Object.class;
    }
    return (Class)params[index];
  }
}