package com.o2oweb.common.dao;
/**
 * @author �������� king
 * @version ����ʱ�䣺Feb 26, 2013 6:18:32 PM
 * ��˵��
 */
import java.io.Serializable;
import java.util.List;

public abstract interface EntityDao<T>
{
  public abstract T get(Serializable paramSerializable);

  public abstract List<T> getAll();

  public abstract void save(Object paramObject);

  public abstract void remove(Object paramObject);

  public abstract void removeById(Serializable paramSerializable);

  public abstract void merge(Object paramObject);

  @SuppressWarnings("unchecked")
  public abstract String getIdName(Class paramClass);
}