package com.withvaadin.vaadinExample.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withvaadin.vaadinExample.Dao.BidhaaDao;
import com.withvaadin.vaadinExample.Entity.Bidhaa;

@Service
public class BidhaaService {
	
	@Autowired
	BidhaaDao bidhaaDao;

	public List<Bidhaa> getAll() {
		return bidhaaDao.getAll();
	}

	public void addNewData(Bidhaa bidhaa) {
		bidhaaDao.addNewData(bidhaa);
	}

}
