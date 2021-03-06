package com.o2oweb.dto;

import com.o2oweb.entity.Order;
import com.o2oweb.entity.User;
import com.o2oweb.util.DateTimeUtil;

public class OrderBean {
	// order
	private Integer orderId;
	private String orderNum;
	private String startTime;
	private String finishTime;
	private String orderName;
	private String address;
	private String isPaied = "NO";
	private String chekOut = "NO";

	private float totalPrice;

	// user
	private Integer userId;
	private String userName;
	private String email;
	private String tel;

	public void setOrder(Order order) {
		if (order == null)
			return;
		this.orderId = order.getOrderId();
		this.orderNum = order.getOrderNum();
		this.startTime = DateTimeUtil.getDateTime(order.getStartTime());
		this.finishTime = DateTimeUtil.getDateTime(order.getFinishTime());
		this.orderName = order.getOrderName();
		this.address = order.getAddress();

		if (order.getIsPaied())
			this.isPaied = "YES";
		if (order.getChekOut())
			this.chekOut = "YES";
	}

	public void setUser(User user) {
		if (user == null)
			return;
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.email = user.getEmail();
		this.tel = user.getTel();
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String isPaied() {
		return isPaied;
	}

	public void setPaied(String isPaied) {
		this.isPaied = isPaied;
	}

	public String isChekOut() {
		return chekOut;
	}

	public void setChekOut(String chekOut) {
		this.chekOut = chekOut;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIsPaied() {
		return isPaied;
	}

	public void setIsPaied(String isPaied) {
		this.isPaied = isPaied;
	}

	public String getChekOut() {
		return chekOut;
	}

}
