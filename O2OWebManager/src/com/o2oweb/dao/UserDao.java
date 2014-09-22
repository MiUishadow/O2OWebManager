package com.o2oweb.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.entity.User;

public interface UserDao {

	public void save(User user);
	public void update(User user);
	public void remove(User user);
	public User getUser(Integer id);
	public User getUser(String loginMes,char type);
	public List<User> find(String hql);
	public Page pagedQuery(DetachedCriteria detachedCriteria, int start,
			int limit);
}
