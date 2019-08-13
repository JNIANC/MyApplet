package com.spring.springboot.service;

import java.util.List;

import com.spring.springboot.entity.Area;

public interface AreaService {

	List<Area> getAreaList();
	
	Area getAreaById(int areaId);
	
	boolean addArea(Area area);
	
	boolean modifyArea(Area area);
	
	boolean deleteArea(int areaId);
}
