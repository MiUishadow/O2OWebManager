package com.o2oweb.service;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.o2oweb.bo.RequestParamBean;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.ItemDao;
import com.o2oweb.entity.Item;

@Component("itemService")
public class ItemService {

	private ItemDao itemDao;

	public void save(Item item) {
		this.itemDao.save(item);
	}

	public void remove(Item item) {
		this.itemDao.remove(item);
	}

	public void update(Item item) {
		this.itemDao.update(item);
	}

	public Item getItem(int itemId) {
		return itemDao.getItem(itemId);
	}

	public Page findPageBean(RequestParamBean paramBean) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Item.class);
		if (paramBean == null) {
			return null;
		}
		return this.itemDao.pagedQuery(detachedCriteria, paramBean.getStart(),
				paramBean.getLimit());
	}

	public void ChangeStock(Item item, int num) {
		this.itemDao.ChangeStock(item, num);
	}

	@Resource
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
}
