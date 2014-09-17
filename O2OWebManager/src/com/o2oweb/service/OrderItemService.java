package com.o2oweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.OrderItemDao;
import com.o2oweb.entity.Orderitem;

@Component("orderItemService")
public class OrderItemService {

	private OrderItemDao orderItemDao;

	public void save(Orderitem orderItem) {
		this.orderItemDao.save(orderItem);
	}

	public void remove(Orderitem orderItem) {
		this.orderItemDao.remove(orderItem);
	}

	public void update(Orderitem orderItem) {
		this.orderItemDao.update(orderItem);
	}

	public Orderitem getOrderItem(int orderItemID) {
		return orderItemDao.getOrderItem(orderItemID);
	}

	public List<Orderitem> getItems(String orderNum) {
		return orderItemDao.getItems(orderNum);
	}

	@Resource
	public void setorderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}
}
