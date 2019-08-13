package com.spring.springboot.service.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.springboot.dao.AreaDao;
import com.spring.springboot.entity.Area;
import com.spring.springboot.service.AreaService;

@Service
@MapperScan("com.spring.springboot.dao")
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;
	@Override
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}

	@Override
	public Area getAreaById(int areaId) {
		//int a = 1/0;
		return areaDao.queryAreaById(areaId);
	}

	//新增主要是areaName不能为空
	@Transactional
	@Override
	public boolean addArea(Area area) {
		if(area.getAreaName() !=null && !"".equals(area.getAreaName())) {
			area.setCreateTime(new Date());
			area.setLastEditTime(new Date());
			try {
				int effectedNum = areaDao.insertArea(area);
				if (effectedNum > 0) {
					return true;
				}else {
					throw new RuntimeException("您插入区域信息失败！ ");
				}
			} catch (Exception e) {
				throw new RuntimeException("您插入区域信息失败:"+e.toString());
			}
		}else {
			throw new RuntimeException("区域信息不能为空！ ");
		}
	}

	//修改主要是areaId不能为空
	@Transactional
	@Override
	public boolean modifyArea(Area area) {
		// 空值判断，主要是areaId不为空
		if (area.getAreaId() !=null && area.getAreaId()>0) {
			area.setLastEditTime(new Date());
			try {
				int effectedNum = areaDao.updateArea(area);
				if (effectedNum > 0) {
					return true;
				}else {
					throw new RuntimeException("更新区域信息错误! ");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新区域信息错误 :" + e.toString());
			}
		}else {
			throw new RuntimeException("区域信息不能为空！ ");
		}
	}

	@Transactional
	@Override
	public boolean deleteArea(int areaId) {
		if (areaId > 0) {
			try {
				int effectedNum = areaDao.deleteArea(areaId);
				if (effectedNum > 0) {
					return true;	
				}else {
					throw new RuntimeException("删除区域失败！ ");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除区域失败: "+e.toString());
			}
		}else {
			throw new RuntimeException("区域Id不能为空");
		}
	}

}
