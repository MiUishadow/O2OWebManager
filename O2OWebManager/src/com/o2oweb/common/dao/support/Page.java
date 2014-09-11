package com.o2oweb.common.dao.support;
/**
 * @author 作者姓名 king
 * @version 创建时间：Feb 25, 2013 10:44:51 AM
 * 类说明
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Page
  implements Serializable
{
  private static int DEFAULT_PAGE_SIZE = 24;

  private int pageSize = DEFAULT_PAGE_SIZE;
  private long start;
  private Object data;
  private long totalCount;

  public long getStart() {
	return start;
}

public void setStart(long start) {
	this.start = start;
}

public Object getData() {
	return data;
}

public void setData(Object data) {
	this.data = data;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public void setTotalCount(long totalCount) {
	this.totalCount = totalCount;
}

public Page()
  {
    this(0L, 0L, DEFAULT_PAGE_SIZE, new ArrayList());
  }

  public Page(long start, long totalSize, int pageSize, Object data)
  {
    this.pageSize = pageSize;
    this.start = start;
    this.totalCount = totalSize;
    this.data = data;
  }

  public long getTotalCount()
  {
    return this.totalCount;
  }

  public long getTotalPageCount()
  {
    if (this.totalCount % this.pageSize == 0L) {
      return this.totalCount / this.pageSize;
    }
    return this.totalCount / this.pageSize + 1L;
  }

  public int getPageSize()
  {
    return this.pageSize;
  }

  public Object getResult()
  {
    return this.data;
  }

  public long getCurrentPageNo()
  {
    return this.start / this.pageSize + 1L;
  }

  public boolean hasNextPage()
  {
    return getCurrentPageNo() < getTotalPageCount() - 1L;
  }

  public boolean hasPreviousPage()
  {
    return getCurrentPageNo() > 1L;
  }

  protected static int getStartOfPage(int pageNo)
  {
    return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
  }

  public static int getStartOfPage(int pageNo, int pageSize)
  {
    return (pageNo - 1) * pageSize;
  }

  public static int getPageNo(int startIndex, int pageSize)
  {
    return startIndex % pageSize == 0 ? startIndex / pageSize : startIndex / pageSize + 1;
  }
}