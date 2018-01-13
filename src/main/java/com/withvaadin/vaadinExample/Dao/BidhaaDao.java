package com.withvaadin.vaadinExample.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.withvaadin.vaadinExample.Entity.Bidhaa;

@Repository
public class BidhaaDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Bidhaa> getAll() {
		return jdbcTemplate.query("SELECT id, goodsName, goodsAmount,time FROM bidhaa", (rs, rowNum)->new Bidhaa(rs.getLong("id"), rs.getString("goodsName"), rs.getDouble("goodsAmount"), rs.getTimestamp("time")));
	}

	public void addNewData(Bidhaa bidhaa) {
		Map<String, Object> bidhaaobj=new HashMap<String,Object>();
		jdbcTemplate.update("INSERT INTO bidhaa (goodsName, goodsAmount, time) VALUES(:goodsName,:goodsAmount,:time)", 
				//new Object[] { 
						bidhaaobj.put("goodsName",bidhaa.getgoodsName()),bidhaaobj.put("goodsAmount",bidhaa.getGoodsAmount()), bidhaaobj.put("time",bidhaa.getTime())
						//}
		);
		
	}

}
