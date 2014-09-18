package com.o2oweb.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.entity.Item;
import com.o2oweb.service.ItemService;
import com.o2oweb.util.BaseAction;
import com.o2oweb.util.MyJson;

@Scope("request")
@Service("itemAction")
public class ItemAction extends BaseAction {

	private final String DETIAL = "itemdetial";
	
	private ItemService itemService;
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
	
	//分页参数
	private String rows;	//每页多少行
	private String page;	//当前页码
	private String orderby;	//过滤条件
	
	public void save() {
		Item item = new Item(itemName, levelId, price, inPrice, discount,
				sailerId, imageId, itemDetail, stockNum, barCode);

		this.itemService.save(item);

		writeResponse("true");
	}

	public void remove() {
		Item item = new Item();
		item.setItemId(itemId);

		this.itemService.remove(item);

		writeResponse("true");
	}

	public void update() {
		Item item = new Item(itemName, levelId, price, inPrice, discount,
				sailerId, imageId, itemDetail, stockNum, barCode);

		this.itemService.update(item);

		writeResponse("true");
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(rows);
		System.out.println(page);
		
		DetachedCriteria dc = DetachedCriteria.forClass(Item.class);
		if("price_desc".endsWith(orderby)){
			dc.addOrder(Order.desc("price"));
		}else if(orderby != null){
			dc.addOrder(Order.asc(orderby));
		}
		Page p = itemService.itemquery(dc, Integer.valueOf(rows), Integer.valueOf(page));
		
		JSONObject obj = MyJson.page2Jsobj(p);
		
		writeResponse(obj);
		return super.execute();
	}
	
	public String itemDetial(){
		JSONObject obj = null;
		if(itemId != null){
			Item item = itemService.getItem(itemId);
			obj = entiy2json(item);
			
		}else {
			obj = new JSONObject();
			obj.accumulate("info", "error");
		}
		
		writeResponse(obj);
		return DETIAL;
	}
	
	/**
	 * 将实体类转换成前端商品详细信息json数据
	 * @param item
	 * @return
	 */
	private JSONObject entiy2json(Item item) {
		JSONObject obj = new JSONObject();
		JSONArray jsa = new JSONArray();
		obj.accumulate("total", 9);
		
		//生成属性数据
		jsa.add(cloum2json("商品编号", item.getItemId()+"", ""));
		jsa.add(cloum2json("商品名称", item.getItemName(), "text"));
		jsa.add(cloum2json("类别编号", item.getLevelId()+"", "text"));
		jsa.add(cloum2json("销售价格", item.getPrice()+"", "text"));
		jsa.add(cloum2json("进货价格", item.getInPrice()+"", "text"));
		jsa.add(cloum2json("折扣", item.getDiscount()+"", "text"));
		jsa.add(cloum2json("供应商编号", item.getSailerId()+"", "text"));
		jsa.add(cloum2json("库存数量", item.getStockNum()+"", "text"));
		jsa.add(cloum2json("条码信息", item.getBarCode(), "text"));
		
		
		obj.accumulate("rows", jsa);
		
		return obj;
	}

	private JSONObject cloum2json(String name,String value,String editor){
		JSONObject obj = new JSONObject();
		
		obj.accumulate("name", name);
		obj.accumulate("value", value);
		obj.accumulate("editor", editor);
		
		return obj;
	}
	
	public void getItem() {
		Item item = this.itemService.getItem(itemId);

		JSONObject obj = JSONObject.fromObject(item);
		writeResponse(obj.toString());
	}

	public void getAttributesByItemId() {
		List<Item> attributes = this.itemService.getAttributes(itemId);

		JSONArray array = JSONArray.fromObject(attributes);
		writeResponse(array.toString());
	}

	public ItemService getItemService() {
		return itemService;
	}
	
	
	@Resource
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getInPrice() {
		return inPrice;
	}

	public void setInPrice(float inPrice) {
		this.inPrice = inPrice;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getSailerId() {
		return sailerId;
	}

	public void setSailerId(Integer sailerId) {
		this.sailerId = sailerId;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public Integer getStockNum() {
		return stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getRows() {
		return rows;
	}

	public String getPage() {
		return page;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	
}
