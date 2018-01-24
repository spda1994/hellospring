package com.withvaadin.vaadinExample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.withvaadin.vaadinExample.dao.GoodsDao;
import com.withvaadin.vaadinExample.dao.ServiceDao;
import com.withvaadin.vaadinExample.entity.Servicess;

@Service
public class ServicessService {
	
	private ServiceDao serviceDao;
	
	public ServicessService(ServiceDao serviceDao) {
		this.serviceDao= serviceDao;
		getAll();
	}
	
	public List<Servicess> getAll() {
		return serviceDao.getAll();
		
	}
	
	public void addNewData(Servicess servicess) {
		serviceDao.addNewData(servicess);
		
	}

	public void removeOne(Servicess servicess1) {
		serviceDao.removeOne(servicess1);
		
	}

	public void update(Servicess servicess2) {
		serviceDao.update(servicess2);
	}

	public void removeAll() {
		serviceDao.removeAll();
		
	}

}
