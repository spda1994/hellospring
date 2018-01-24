package com.withvaadin.vaadinExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.yaml.snakeyaml.DumperOptions;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import com.withvaadin.vaadinExample.entity.Servicess;
import com.withvaadin.vaadinExample.service.ServicessService;

@SpringComponent
@UIScope
public class ServiceGrid extends Grid<Servicess>{

	@Autowired
	private ServicessService servicess;
	

	public ServiceGrid(ServicessService servicess) {
		this.servicess = servicess;
		Build();
	}

	private void Build() {
		addColumn(Servicess::getServiceName).setCaption("Name of Service");
		addColumn(Servicess::getServiceAmount).setCaption("amount spent");
		addColumn(Servicess::getDateField).setCaption("DumperOptions date");
		setItems(servicess.getAll());
		
	}

}
