package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.Area;

public interface AreaDAO {
	/*test*/
	public List<Area> listAllArea();
	public boolean createArea(Area area);
	public int getMaxAreaID();
	public Area getAreaByID(int areaid);
}
