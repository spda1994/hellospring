package com.withvaadin.vaadinExample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.withvaadin.vaadinExample.entity.Goods;
import com.withvaadin.vaadinExample.entity.Servicess;

@Repository
public class ServiceDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Servicess> getAll() {
		return jdbcTemplate.query("SELECT id, serviceName, serviceAmount,time FROM huduma", (rs, rowNum)->new Servicess(rs.getLong("id"), rs.getString("serviceName"), rs.getDouble("serviceAmount"), rs.getTimestamp("time")));
	}

	public void addNewData(Servicess servicess) {
		jdbcTemplate.update("INSERT INTO huduma (serviceName, serviceAmount, time) VALUES(?,?,?)",
				servicess.getServiceName(),
				servicess.getServiceAmount(),
				servicess.getDateField()
		);
		
	}

	public void removeOne(Servicess servicess1) {
		jdbcTemplate.update("DELETE FROM huduma WHERE id = ?",servicess1.getId());
		
	}

	public void update(Servicess servicess2) {
		jdbcTemplate.update("UPDATE huduma SET serviceName=?, serviceAmount=?, time=? WHERE id=?",
				
				servicess2.getServiceName(),
				servicess2.getServiceAmount(),
				servicess2.getDateField(),
				servicess2.getId()
				);
		
	}

	public void removeAll() {
		jdbcTemplate.update("DELETE FROM huduma WHERE 1");
	}

}
