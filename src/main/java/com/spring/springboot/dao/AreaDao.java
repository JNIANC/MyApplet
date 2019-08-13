package com.spring.springboot.dao;

import java.util.List;

import com.spring.springboot.entity.Area;

public interface AreaDao {

	List<Area> queryArea();
	
	Area queryAreaById(int areaId);
	
	int insertArea(Area area);
	
	int updateArea(Area area);
	
	int deleteArea(int areaId);
}
