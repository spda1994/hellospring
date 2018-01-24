package com.withvaadin.vaadinExample;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;

import com.vaadin.data.Binder;
import com.vaadin.data.converter.LocalDateToDateConverter;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.withvaadin.vaadinExample.entity.Servicess;
import com.withvaadin.vaadinExample.service.ServicessService;

@SpringComponent
@UIScope
public class ServiceForm extends VerticalLayout {
	
	private TextField nameField=new TextField("Name of Service");
	private TextField amountField= new TextField("Amount Used ( TSH)");
	private DateField dateField=new DateField("Date created");
	private Button saveButton;
	
	private Servicess servicess;
	
	private ServicessService servicessService;
	private Binder<Servicess> binder=new Binder<Servicess>(Servicess.class);
	private Label title;

	public ServiceForm(ServicessService servicessService) {
		this.servicessService=servicessService;
		
		title=new Label("RECORD YOUR NEW EXPENSES");
		saveButton=new Button("save", event -> save());
		Build();
	}

	private void Build() {
		
		title.setStyleName(ValoTheme.LABEL_H3);
		addComponent(title);
		setComponentAlignment(title, Alignment.TOP_LEFT); 
		
		addComponent(nameField);
		addComponent(amountField);
		addComponent(dateField);
		addComponent(saveButton);
		
		binder.forField(nameField).bind(Servicess::getServiceName,Servicess::setServiceName);
		binder.forField(amountField).withConverter(new StringToDoubleConverter("This should not be string")).bind(Servicess::getServiceAmount, Servicess::setServiceAmount);
		binder.forField(dateField).withConverter(new LocalDateToDateConverter()).bind(Servicess::getDateField, Servicess::setDateField);
		
	}
	
	public void save() {
		if (binder.isValid()) {
			servicessService.addNewData(binder.getBean());
			
		}
	}

	public void setService(Servicess servicess2) {
		this.servicess=servicess2;
		binder.setBean(servicess2);
		
	}

}
