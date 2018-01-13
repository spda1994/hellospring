package com.withvaadin.vaadinExample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Customer> findAll(){
		return jdbcTemplate.query("SELECT id, firstName,lastName FROM customer", (rs, rowNum)-> new Customer(rs.getLong("id"),rs.getString("firstName"),rs.getString("lastName")));
		
	}
	
	public void update(Customer customer) {
		jdbcTemplate.update("UPDATE customer SET firstName=?, lastName=? WHERE id=?",customer.getFirstName(), customer.getLastName(), customer.getId());
	}

}
