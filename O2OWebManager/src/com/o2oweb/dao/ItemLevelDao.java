package com.o2oweb.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.entity.Itemlevel;

public interface ItemLevelDao {
	public void save(Itemlevel itemLevel);

	public void update(Itemlevel itemLevel);

	public void remove(Itemlevel itemLevel);

	public Itemlevel getLevel(int levelID);

	public Itemlevel getLevel(int superId, String levelName);

	public List<Itemlevel> getAllLevel(int levelID);

	public List<Itemlevel> getNextLevels(int levelID);
	public Page pagedQuery(DetachedCriteria detachedCriteria, int start, int limit);
}
