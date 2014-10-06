package com.o2oweb.action;

import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.dto.ItemLevelBean;
import com.o2oweb.entity.Itemlevel;
import com.o2oweb.service.ItemLevelService;
import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("levelAction")
public class LevelAction extends BaseAction {
	@Autowired
	private ItemLevelService itemLevelService;

	private Integer category;
	private String levelName;
	private Integer superId;
	private boolean isGen = false;

	@Override
	public String execute() throws Exception {
		if (this.isGen) {
			ItemLevelBean[] ilb = new ItemLevelBean[] { new ItemLevelBean() };
			ilb[0].setId(this.category);
			ilb[0].setText("商品分类");

			List<Itemlevel> sublevels = itemLevelService
					.getNextLevels(this.category);
			List<ItemLevelBean> toJsonArray = new LinkedList<ItemLevelBean>();
			for (Itemlevel sublevel : sublevels) {
				ItemLevelBean sl = new ItemLevelBean();
				sl.setId(sublevel.getIdItemLevel());
				sl.setText(sublevel.getLevelName() + " 编号:"
						+ sublevel.getIdItemLevel());
				toJsonArray.add(sl);
			}
			ilb[0].setChildren(toJsonArray);

			JSONArray jsa = JSONArray.fromObject(ilb);
			writeResponse(jsa.toString());

			return super.execute();
		}
		List<Itemlevel> sublevels = itemLevelService.getNextLevels(category);
		List<ItemLevelBean> toJsonArray = new LinkedList<ItemLevelBean>();
		for (Itemlevel sublevel : sublevels) {
			ItemLevelBean ilb = new ItemLevelBean();
			ilb.setId(sublevel.getIdItemLevel());
			ilb.setText(sublevel.getLevelName() + " 编号:"
					+ sublevel.getIdItemLevel());
			toJsonArray.add(ilb);
		}
		JSONArray jsa = JSONArray.fromObject(toJsonArray);
		writeResponse(jsa.toString());
		return super.execute();
	}

	public void addLevel() {
		Itemlevel il = this.itemLevelService.getLevel(superId, levelName);
		if (il == null) {
			il = new Itemlevel();
			il.setSurperId(superId);
			il.setLevelName(levelName);

			this.itemLevelService.save(il);

			ItemLevelBean[] ilb = new ItemLevelBean[] { new ItemLevelBean() };
			il = this.itemLevelService.getLevel(superId, levelName);
			ilb[0].setId(il.getIdItemLevel());
			ilb[0].setText(il.getLevelName() + " 编号:" + il.getIdItemLevel());
			JSONArray jsa = JSONArray.fromObject(ilb);
			writeResponse(jsa.toString());
		} else {
			writeResponse("false");
		}
	}

	public void updateLevel() {
		Itemlevel il = this.itemLevelService.getLevel(category);
		il.setLevelName(levelName);

		this.itemLevelService.update(il);

		writeResponse("true");
	}

	public void deleteLevel() {
		Itemlevel il = new Itemlevel();
		il.setIdItemLevel(this.category);

		this.itemLevelService.remove(il);

		writeResponse("true");
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Integer getSuperId() {
		return superId;
	}

	public void setSuperId(Integer superId) {
		this.superId = superId;
	}

	public boolean getIsGen() {
		return isGen;
	}

	public void setIsGen(boolean isGen) {
		this.isGen = isGen;
	}

}
