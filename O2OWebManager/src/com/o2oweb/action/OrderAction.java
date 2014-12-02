package com.o2oweb.action;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONObject;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dto.OrderBean;
import com.o2oweb.dto.OrderItemBean;
import com.o2oweb.entity.Order;
import com.o2oweb.entity.OrderItem;
import com.o2oweb.service.ItemService;
import com.o2oweb.service.OrderItemService;
import com.o2oweb.service.OrderService;
import com.o2oweb.service.UserService;
import com.o2oweb.util.BaseAction;
import com.o2oweb.util.MyJson;

@Scope("request")
@Service("orderAction")
public class OrderAction extends BaseAction {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;

	private Integer orderId;
	private String orderNum;
	private Integer userId;
	private Date startTime;
	private Date finishTime;
	private String orderName;
	private String address;
	private boolean paied;
	private boolean chekOut;

	// 分页参数
	private String rows; // 每页多少行
	private String page; // 当前页码
	private String orderby; // 过滤条件

	public void save() {
		Order order = new Order(orderNum, userId, startTime, finishTime,
				orderName, address, paied, chekOut);

		this.orderService.save(order);

		writeResponse(true);
	}

	public void remove() {
		Order order = new Order();
		order.setOrderId(orderId);

		this.orderService.remove(order);

		writeResponse(true);
	}

	public void update() {
		Order order = new Order(orderNum, userId, startTime, finishTime,
				orderName, address, paied, chekOut);
		order.setOrderId(orderId);

		this.orderService.update(order);

		writeResponse(true);
	}

	public void getOrder() {
		Order order = this.orderService.getOrder(orderNum);

		JSONObject obj = JSONObject.fromObject(order);
		writeResponse(obj.toString());
	}

	public void pageQuery() {
		DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
		if (orderby != null) {
			if (orderby.equals("chekOutNow")) {
				dc.add(Restrictions.eq("chekOut", false));
				dc.addOrder(org.hibernate.criterion.Order.asc("orderNum"));
			}else if("isPaied".equals(orderby)){
				dc.add(Restrictions.eq("isPaied", false));
			}else if("chekOut".equals(orderby)){
				dc.add(Restrictions.eq("chekOut", false));
			} else {
				dc.addOrder(org.hibernate.criterion.Order.asc(orderby));
			}
		}
		if (orderNum != null && !orderNum.trim().equals("")) {
			dc.add(Restrictions.eq("orderNum", orderNum));
		}

		Page p = this.orderService.pagedQuery(dc, Integer.valueOf(rows),
				Integer.valueOf(page) - 1);

		List<OrderBean> obs = new LinkedList<OrderBean>();
		List<Order> os = (List<Order>) p.getData();
		for (Order o : os) {
			OrderBean ob = new OrderBean();
			ob.setOrder(o);
			ob.setTotalPrice(this.orderItemService.getTotalPriceByOrderNum(o
					.getOrderNum()));
			ob.setUser(this.userService.getUser(o.getUserId()));

			obs.add(ob);
		}

		p.setData(obs);
		JSONObject obj = MyJson.page2Jsobj(p);

		writeResponse(obj);
	}

	public void getOrderItem() {
		List<OrderItemBean> oibs = new LinkedList<OrderItemBean>();
		List<OrderItem> ois = this.orderItemService.getItems(orderNum);
		for (OrderItem oi : ois) {
			OrderItemBean oib = new OrderItemBean();
			oib.setOrderItem(oi);
			oib.setItem(this.itemService.getItem(oi.getItemId()));

			oibs.add(oib);
		}

		OrderItemBean oib = new OrderItemBean();
		oib.setItemName("总价格");
		oib.setItemPrice(this.orderItemService
				.getTotalPriceByOrderNum(orderNum));
		oibs.add(oib);

		Page page = new Page();
		page.setTotalCount(oibs.size());
		page.setData(oibs);
		JSONObject obj = MyJson.page2Jsobj(page);

		writeResponse(obj);
	}

	public void dealOrder() {
		Order order = this.orderService.getOrder(orderNum);
		if (order.getChekOut()) {
			writeResponse("该订单已处理！");
			return;
		}
			order.setChekOut(this.chekOut);

			this.orderService.update(order);

			writeResponse("true");
	}

	public void dealPaied() {
		Order order = this.orderService.getOrder(orderNum);
		if (order.getIsPaied()) {
			writeResponse("该订单已支付！");
			return;
		}
if(order.getChekOut()){
		order.setIsPaied(this.paied);
		order.setFinishTime(new Date());

		this.orderService.update(order);

		writeResponse("true");
}else{
	writeResponse("请先处理订单！");
}
	}

	public void checkOrder() {
		List<Order> os = this.orderService.getUnchecked();

		writeResponse(os.size() + "");
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
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

	public boolean isPaied() {
		return paied;
	}

	public void setPaied(boolean paied) {
		this.paied = paied;
	}

	public boolean isChekOut() {
		return chekOut;
	}

	public void setChekOut(boolean chekOut) {
		this.chekOut = chekOut;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		if (page.equals("0"))
			this.page = "1";
		else
			this.page = page;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

}
