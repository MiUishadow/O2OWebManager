package com.o2oweb.service;

import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.o2oweb.dao.Index3Dao;
import com.o2oweb.dao.ItemDao;
import com.o2oweb.dao.ItemfDao;
import com.o2oweb.dao.RollBarDao;
import com.o2oweb.entity.Index3;
import com.o2oweb.entity.Item;
import com.o2oweb.entity.Itemf;
import com.o2oweb.entity.Rollbar;

@Component("index3Service")
public class Index3Service {

	@Autowired
	private ItemfDao itemfDao;
	@Autowired
	private RollBarDao rollbarDao;
	@Autowired
	private Index3Dao index3Dao;
	@Autowired
	private ItemDao itemDao;
	
	public JSONObject getEntirePage(){
		JSONObject obj = new JSONObject();
		
		Index3 index3 = index3Dao.getIndex3(1);
		
		Rollbar rollbar = rollbarDao.getRollbar(index3.getRollbarid());
		JSONObject json_rb = JSONObject.fromObject(rollbar);
		obj.accumulate("rollbar", json_rb);
		
		Itemf onef = itemfDao.getItemf(index3.getFoneId());
		
		JSONObject onefobj = new JSONObject();
		onefobj.accumulate("FName", onef.getFname());
		onefobj.accumulate("items", itemf2array(onef));
		obj.accumulate("oneF", onefobj);
		
		Itemf twof = itemfDao.getItemf(index3.getFtwoId());
		JSONObject twofobj = new JSONObject();
		twofobj.accumulate("FName", twof.getFname());
		twofobj.accumulate("items", itemf2array(twof));
		obj.accumulate("twoF", twofobj);
		
		Itemf threef = itemfDao.getItemf(index3.getFthreeId());
		JSONObject threefobj = new JSONObject();
		threefobj.accumulate("FName", threef.getFname());
		threefobj.accumulate("items", itemf2array(threef));
		obj.accumulate("threeF", threefobj);
		
		Itemf fourf = itemfDao.getItemf(index3.getFfourId());
		JSONObject fourfobj = new JSONObject();
		fourfobj.accumulate("FName", fourf.getFname());
		fourfobj.accumulate("items", itemf2array(fourf));
		obj.accumulate("fourF", fourfobj);
		
		return obj;
	}
	
	private JSONArray itemf2array(Itemf itemf){
		JSONArray jsa = null;
		
		List<Item> items = new LinkedList<Item>();
		
		if(itemf.getItem1()!=null){
			items.add(itemDao.getItem(itemf.getItem1()));
		}
		if(itemf.getItem2()!=null)
			items.add(itemDao.getItem(itemf.getItem2()));
		if(itemf.getItem3()!=null)
			items.add(itemDao.getItem(itemf.getItem3()));
		if(itemf.getItem4()!=null)
			items.add(itemDao.getItem(itemf.getItem4()));
		if(itemf.getItem5()!=null)
			items.add(itemDao.getItem(itemf.getItem5()));
		if(itemf.getItem6()!=null)
			items.add(itemDao.getItem(itemf.getItem6()));
		if(itemf.getItem7()!=null)
			items.add(itemDao.getItem(itemf.getItem7()));
		if(itemf.getItem8()!=null)
			items.add(itemDao.getItem(itemf.getItem8()));
		
		jsa = JSONArray.fromObject(items);
		
		return jsa;
	}
}
