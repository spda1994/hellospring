package com.withvaadin.vaadinExample.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withvaadin.vaadinExample.dao.GoodsDao;
import com.withvaadin.vaadinExample.entity.Goods;

@Service
public class GoodsService {
	
	@Autowired
	GoodsDao goodsDao;

	public List<Goods> getAll() {
		return goodsDao.getAll();
	}

	public void addNewData(Goods goods) {
		goodsDao.addNewData(goods);
		
	}
	
	public void removeOne(Goods goods1) {
		goodsDao.removeOne(goods1);
	}
	
	public void removeAll() {
		goodsDao.removeAll();
	}
	
	public void update(Goods goods2) {
		goodsDao.updateBidhaa(goods2);
	}

}
