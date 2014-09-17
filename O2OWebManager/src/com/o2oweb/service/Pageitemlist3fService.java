package com.o2oweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.Pageitemlist3fDao;
import com.o2oweb.entity.Pageitemlist3f;

@Component("pageitemlist3fService")
public class Pageitemlist3fService {

	private Pageitemlist3fDao pageitemlist3fDao;

	public void save(Pageitemlist3f pageitemlist3f) {
		this.pageitemlist3fDao.save(pageitemlist3f);
	}

	public void remove(Pageitemlist3f pageitemlist3f) {
		this.pageitemlist3fDao.remove(pageitemlist3f);
	}

	public void update(Pageitemlist3f pageitemlist3f) {
		this.pageitemlist3fDao.update(pageitemlist3f);
	}

	public Pageitemlist3f getpageitemlist3f(String loginMes, char type) {
		return pageitemlist3fDao.getPageitemlist3f(loginMes, type);
	}

	public List<Pageitemlist3f> find(String hql) {
		return this.pageitemlist3fDao.find(hql);
	}

	@Resource
	public void setpageitemlist3fDao(Pageitemlist3fDao pageitemlist3fDao) {
		this.pageitemlist3fDao = pageitemlist3fDao;
	}
}
