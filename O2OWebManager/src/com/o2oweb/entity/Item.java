package com.o2oweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "item", catalog = "o2owebsit", uniqueConstraints = @UniqueConstraint(columnNames = "barCode"))
public class Item implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private String itemName;
	private Integer levelId;
	private float price;
	private float inPrice;
	private Integer discount;
	private Integer sailerId;
	private Integer imageId;
	private String itemDetail;
	private Integer stockNum;
	private String barCode;

	// Constructors

	/** default constructor */
	public Item() {
		this.discount = 0;
		this.itemName = "";
		this.levelId = 0;
		this.price = 0;
		this.inPrice = 0;
		this.stockNum = 0;
		this.barCode = "";
	}

	/** minimal constructor */
	public Item(String itemName, Integer levelId, float price, float inPrice,
			Integer discount, Integer stockNum) {
		this.itemName = itemName;
		this.levelId = levelId;
		this.price = price;
		this.inPrice = inPrice;
		this.discount = discount;
		this.stockNum = stockNum;
	}

	/** full constructor */
	public Item(String itemName, Integer levelId, float price, float inPrice,
			Integer discount, Integer sailerId, Integer imageId,
			String itemDetail, Integer stockNum, String barCode) {
		this.itemName = itemName;
		this.levelId = levelId;
		this.price = price;
		this.inPrice = inPrice;
		this.discount = discount;
		this.sailerId = sailerId;
		this.imageId = imageId;
		this.itemDetail = itemDetail;
		this.stockNum = stockNum;
		this.barCode = barCode;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "itemId", unique = true, nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "itemName", nullable = false)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "levelId", nullable = false)
	public Integer getLevelId() {
		return this.levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	@Column(name = "price", nullable = false, precision = 12, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "InPrice", nullable = false, precision = 12, scale = 0)
	public float getInPrice() {
		return this.inPrice;
	}

	public void setInPrice(float inPrice) {
		this.inPrice = inPrice;
	}

	@Column(name = "discount", nullable = false)
	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Column(name = "sailerId")
	public Integer getSailerId() {
		return this.sailerId;
	}

	public void setSailerId(Integer sailerId) {
		this.sailerId = sailerId;
	}

	@Column(name = "imageID")
	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	@Column(name = "itemDetail", length = 3000)
	public String getItemDetail() {
		return this.itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	@Column(name = "StockNum", nullable = false)
	public Integer getStockNum() {
		return this.stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	@Column(name = "barCode", unique = true, length = 45)
	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

}