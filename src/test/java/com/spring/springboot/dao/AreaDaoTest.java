package com.spring.springboot.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.springboot.entity.Area;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.spring.springboot.dao")
public class AreaDaoTest {

	@Autowired
	private AreaDao areaDao;
	
	@Test
	@Ignore
	public void testQueryArea() {
		List<Area> areaList = areaDao.queryArea();
		System.out.println(areaList.size());
	}


	@Test
	@Ignore
	public void testQueryAreaById() {
		Area area =areaDao.queryAreaById(1);
		System.out.println(area);
	}

	@Test
	@Ignore
	public void testInsertArea() {
		Area area = new Area();
		area.setAreaName("阳西");
		area.setPriority(5);
		int colums = areaDao.insertArea(area);
		System.out.println(colums);
	}

	@Test
	@Ignore
	public void testUpdateArea() {
		Area area = new Area();
		area.setAreaId(2);
		area.setAreaName("沙扒湾");
		area.setLastEditTime(new Date());
		int colums = areaDao.updateArea(area);
	}

	@Test
	@Ignore
	public void testDeleteArea() {
		int colums = areaDao.deleteArea(5);
		System.out.println(colums);
	}

}
