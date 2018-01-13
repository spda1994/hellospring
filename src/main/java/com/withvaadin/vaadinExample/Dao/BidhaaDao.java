package com.withvaadin.vaadinExample.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.withvaadin.vaadinExample.Entity.Bidhaa;

@Repository
public class BidhaaDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Bidhaa> getAll() {
		return jdbcTemplate.query("SELECT id, goodsName, goodsAmount,timeCreated FROM bidhaa", (rs, rowNum)->new Bidhaa(rs.getLong("id"), rs.getString("goodsName"), rs.getDouble("goodsAmount"), rs.getTimestamp("timeCreated")));
	}

	public void addNewData(Bidhaa bidhaa) {
		Map<String, Object> bidhaaobj=new HashMap<String,Object>();
		jdbcTemplate.update("INSERT INTO bidhaa (goodsName, goodsAmount, timeCreated) VALUES(?,?,?)",
				bidhaa.getgoodsName(),
				bidhaa.getGoodsAmount(),
				bidhaa.getTime()
		);
		
	}

}
