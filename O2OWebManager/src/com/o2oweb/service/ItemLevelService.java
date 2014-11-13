package com.o2oweb.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.directwebremoting.json.types.JsonObject;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.ItemLevelDao;
import com.o2oweb.entity.Itemlevel;

@Component("itemLevelService")
public class ItemLevelService {

	private ItemLevelDao ItemLevelDao;

	public void save(Itemlevel ItemLevel) {
		this.ItemLevelDao.save(ItemLevel);
	}

	public void remove(Itemlevel ItemLevel) {
		this.ItemLevelDao.remove(ItemLevel);
	}

	public void update(Itemlevel ItemLevel) {
		this.ItemLevelDao.update(ItemLevel);
	}

	public Itemlevel getLevel(int levelID) {
		return ItemLevelDao.getLevel(levelID);
	}

	public Itemlevel getLevel(int superId, String levelName) {
		return ItemLevelDao.getLevel(superId, levelName);
	}

	public List<Itemlevel> getAllLevel(int levelID) {
		return ItemLevelDao.getAllLevel(levelID);
	}

	public List<Itemlevel> getNextLevels(int levelID) {
		List<Itemlevel> sublevels =  ItemLevelDao.getNextLevels(levelID);
		DetachedCriteria dc = DetachedCriteria.forClass(Itemlevel.class);
		dc.add(Restrictions.like("subsuperIds","%"+ levelID + "*"+"%"));
		Page p = ItemLevelDao.pagedQuery(dc, 0, Integer.MAX_VALUE);
		List<Itemlevel> ssublevels = (List<Itemlevel>) p.getData();
		sublevels.addAll(ssublevels);
		return sublevels;
	}

	@Resource
	public void setItemLevelDao(ItemLevelDao ItemLevelDao) {
		this.ItemLevelDao = ItemLevelDao;
	}

	public boolean addssublevel(Itemlevel itemlevel, Integer superId,
			String levelName) {
		String ssublevel = itemlevel.getSubsuperIds();
		if(itemlevel.getSurperId().equals(superId)){
			//如果与第一父级相同，直接返回
			return false;
		}
		if(ssublevel == null || "".endsWith(ssublevel)){
			//如果为空说明之前为设置过第二父级
			ssublevel = new String(superId + "*"+",");
		}else{
			//第二父级字段有数据
			if(ssublevel.contains(superId +"*")){
				//如果已经添加过直接返回
				return false;
			}
			ssublevel = ssublevel + superId + "*"+ ",";
		}
		itemlevel.setSubsuperIds(ssublevel);
		ItemLevelDao.update(itemlevel);
		return true;
	}

	public void remvessupid(Itemlevel itemlevel, Integer superId) {
		String[] ssuperIds = itemlevel.getSubsuperIds().split(",");
		
		if(itemlevel.getSurperId().equals(superId)){
			String id_text = ssuperIds[0];
			Integer id_int = Integer.valueOf(id_text.substring(0, id_text.length()-1));
			itemlevel.setSurperId(id_int);
			removfromarray(itemlevel,ssuperIds,id_text);
		}else{
			removfromarray(itemlevel,ssuperIds, superId + "*");
		}
	}

	private void removfromarray(Itemlevel itemlevel,String[] ssuperIds, String id_text) {
		if(ssuperIds.length > 1){
			//如果不止一个第二父级
			String newssuperids = new String();
			for(int i = 0;i<ssuperIds.length;i++){
				if(!ssuperIds[i].endsWith(id_text)){
					newssuperids += ssuperIds[i];
				}
			}
			itemlevel.setSubsuperIds(newssuperids);
		}else{
			//如果只有一个第二父级
			itemlevel.setSubsuperIds(null);
		}
		ItemLevelDao.update(itemlevel);
	}
}
