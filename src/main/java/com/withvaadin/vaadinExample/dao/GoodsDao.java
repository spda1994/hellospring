package com.withvaadin.vaadinExample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.withvaadin.vaadinExample.entity.Goods;

@Repository
public class GoodsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Goods> getAll() {
		return jdbcTemplate.query("SELECT id, goodsName, goodsAmount,time FROM bidhaa", (rs, rowNum)->new Goods(rs.getLong("id"), rs.getString("goodsName"), rs.getDouble("goodsAmount"), rs.getTimestamp("time")));
	}

	public void addNewData(Goods goods) {
		jdbcTemplate.update("INSERT INTO bidhaa (goodsName, goodsAmount, time) VALUES(?,?,?)",
				goods.getgoodsName(),
				goods.getGoodsAmount(),
				goods.getTime()
		);
		
	}

	public void removeOne(Goods goods1) {
		jdbcTemplate.update("DELETE FROM bidhaa WHERE id = ?", goods1.getId());
		
	}
	
	public void removeAll() {
		jdbcTemplate.update("DELETE FROM bidhaa WHERE 1");
	}
	
	public void updateBidhaa(Goods goods2) {
		jdbcTemplate.update("UPDATE bidhaa SET goodsName=?, goodsAmount=?, time=? WHERE id=?",
				goods2.getgoodsName(), goods2.getGoodsAmount(), goods2.getTime(), goods2.getId());
		
	}

}
