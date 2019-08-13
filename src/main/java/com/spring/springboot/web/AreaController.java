package com.spring.springboot.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.entity.Area;
import com.spring.springboot.service.AreaService;

@RestController
@RequestMapping("/superadmin")
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value="/listarea",method=RequestMethod.GET)
	private Map<String, Object> listArea(){
		Map<String, Object> modeMap = new HashMap<String,Object>();
		List<Area> list = areaService.getAreaList();
		modeMap.put("areaList", list);
		return modeMap;
	}
	
	@RequestMapping(value="/getareabyid",method=RequestMethod.GET)
	private Map<String, Object> getAreaById(Integer areaId){
		Map<String, Object> modeMap = new HashMap<String, Object>();
		Area area = areaService.getAreaById(areaId);
		modeMap.put("area", area);
		return modeMap;
	}
	
	@RequestMapping(value="/addarea",method=RequestMethod.POST)
	private Map<String, Object> addArea(@RequestBody Area area){
		Map<String, Object> modeMap = new HashMap<String, Object>();
		modeMap.put("success", areaService.addArea(area));
		return modeMap;
	}
	
	@RequestMapping(value="/modifyarea",method=RequestMethod.POST)
	private Map<String, Object> modifyArea(@RequestBody Area area){
		Map<String, Object> modeMap = new HashMap<String, Object>();
		modeMap.put("success", areaService.modifyArea(area));
		return modeMap;
	}
	
	@RequestMapping(value="/removearea",method=RequestMethod.GET)
	private Map<String, Object> removeArea(Integer areaId){
		Map<String, Object> modeMap = new HashMap<String, Object>();
		modeMap.put("success", areaService.deleteArea(areaId));
		return modeMap;
	}
}
