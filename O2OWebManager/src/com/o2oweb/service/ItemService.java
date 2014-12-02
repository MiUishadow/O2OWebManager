package com.o2oweb.service;

import java.util.List;

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
		Item oldItem = this.itemDao.getItem(item.getItemId());
		
		if(item.getItemName() != null){
			oldItem.setItemName(item.getItemName());
		}
		if(item.getLevelId() != null){
			oldItem.setLevelId(item.getLevelId());
		}
		if(item.getPrice() != 0){
			oldItem.setPrice(item.getPrice());
		}
		if(item.getInPrice() != 0){
			oldItem.setInPrice(item.getInPrice());
		}
		if(item.getDiscount() != null){
			oldItem.setDiscount(item.getDiscount());
		}
		if(item.getSailerId() != null){
			oldItem.setSailerId(item.getSailerId());
		}
		if(item.getImageId() != null){
			oldItem.setImageId(item.getImageId());
		}
		if(item.getItemDetail() != null){
			oldItem.setItemDetail(item.getItemDetail());
		}
		if(item.getStockNum() != null){
			oldItem.setStockNum(item.getStockNum());
		}
		if(item.getBarCode() != null){
			oldItem.setBarCode(item.getBarCode());
		}
		
		this.itemDao.update(oldItem);
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

	public List<Item> getAttributes(Integer itemId) {
		// TODO Auto-generated method stub
		return null;
	}
	public Page itemquery(DetachedCriteria dc,int rows,int page){
		Page p = itemDao.pagedQuery(dc, rows * (page-1), rows);
		return p;
	}
	
	public void changeimageURL(){
		DetachedCriteria dc = DetachedCriteria.forClass(Item.class);
		Page p = itemDao.pagedQuery(dc, 0, Integer.MAX_VALUE);
		
		List<Item> items = (List) p.getData();
		System.out.println(items.size());
		for(Item item : items){
			String content = item.getItemDetail();
			if(content != null){
				content.replaceAll("/O2OWebManager/image/getImage", "/O2OWebSit/image/getImage");
				item.setItemDetail(content);
				itemDao.update(item);
				System.out.println(item.getItemId());
				System.out.println(item.getItemDetail());
			}
		}
	}
}
