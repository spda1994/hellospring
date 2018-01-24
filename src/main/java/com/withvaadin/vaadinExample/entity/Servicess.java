package com.withvaadin.vaadinExample.entity;

import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Servicess { 
	private long id;
	private String serviceName;
	private Double serviceAmount = 0.0;
	private Date time;
	 
	public Servicess(Long id, String serviceName, Double serviceAmount, Date time) {
		super();
		this.id=id;
		this.serviceName = serviceName;
		this.serviceAmount = serviceAmount;
		this.time = time;
	}

	public Servicess() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Double getServiceAmount() {
		return serviceAmount;
	}

	public void setServiceAmount(Double serviceAmount) {
		this.serviceAmount = serviceAmount;
	}

	public Date getDateField() {
		return time;
	}

	public void setDateField(Date dateField) {
		this.time = dateField;
	}
}
