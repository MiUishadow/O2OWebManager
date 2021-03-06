package com.o2oweb.dto;

import com.o2oweb.entity.Item;
import com.o2oweb.entity.OrderItem;

public class OrderItemBean {
	// orderItem
	private Integer idOrderItem;
	private Integer itemNum;
	private float itemPrice;

	// item
	private Integer itemId;
	private String itemName;
	private Integer levelId;
	private Integer imageId;
	private String barCode;

	public void setOrderItem(OrderItem orderItem) {
		if (orderItem == null)
			return;
		this.idOrderItem = orderItem.getIdOrderItem();
		this.itemNum = orderItem.getItemNum();
		this.itemPrice = orderItem.getItemPrice();
	}

	public void setItem(Item item) {
		if (item == null)
			return;
		this.itemId = item.getItemId();
		this.itemName = item.getItemName();
		this.levelId = item.getLevelId();
		this.imageId = item.getImageId();
		this.barCode = item.getBarCode();
	}

	public Integer getIdOrderItem() {
		return idOrderItem;
	}

	public void setIdOrderItem(Integer idOrderItem) {
		this.idOrderItem = idOrderItem;
	}

	public Integer getItemNum() {
		return itemNum;
	}

	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

}
