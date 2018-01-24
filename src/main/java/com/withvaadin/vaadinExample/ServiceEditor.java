package com.withvaadin.vaadinExample;

import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.LocalDateToDateConverter;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.withvaadin.vaadinExample.entity.Servicess;
import com.withvaadin.vaadinExample.service.ServicessService;

@SuppressWarnings("deprecation")
@SpringComponent
@UIScope
public class ServiceEditor extends VerticalLayout{
	
	private TextField namefield=new TextField("name of services");
	private TextField amount = new TextField("amout used");
	private DateField dateField = new DateField("Due date");
	
	private Button save = new Button("Update", FontAwesome.SAVE);
	private Button delete = new Button("Delete", FontAwesome.TRASH_O);
	private Button cancel = new Button("Cancel");
	
	HorizontalLayout actions = new HorizontalLayout(save, delete, cancel);
	
	private Servicess servicess;
	private ServiceGrid serviceGrid;
	private ServicessService servicessService;
	
	Binder<Servicess> binder = new Binder<Servicess>(Servicess.class);
	private Label title;
	
	@Autowired
	public ServiceEditor(ServicessService servicessService, ServiceGrid serviceGrid) {
		this.serviceGrid = serviceGrid;
		this.servicessService = servicessService;
		save.addClickListener(e -> save());
		delete.addClickListener(event -> delete());
		cancel.addClickListener(e -> cancel() );
		 title=new Label("EDIT YOUR INFORMATION");
		build();
		
	}
	
	
	private void build() {
		
		title.setStyleName(ValoTheme.LABEL_H3);
		addComponent(title);
		setComponentAlignment(title, Alignment.TOP_LEFT);
		
		addComponent(namefield);
		addComponent(amount);
		addComponent(dateField);
		addComponent(actions);
		// using naming convention
		//binder.bindInstanceFields(this);
		
		binder.forField(namefield).bind(Servicess::getServiceName,Servicess::setServiceName);
		binder.forField(amount).withConverter(new StringToDoubleConverter("This should not be string")).bind(Servicess::getServiceAmount, Servicess::setServiceAmount);
		binder.forField(dateField).withConverter(new LocalDateToDateConverter()).bind(Servicess::getDateField, Servicess::setDateField);
		
		
		//setSpacing(true);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		delete.setStyleName(ValoTheme.BUTTON_DANGER);
		cancel.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		
	}
	
	private void cancel() {
		
	}

	
	private void delete() {
		servicessService.removeOne(binder.getBean());
		servicessService.getAll();
		serviceGrid.select(binder.getBean());
	}

	private void save() {
		servicessService.update(binder.getBean());
		servicessService.getAll();
		serviceGrid.select(binder.getBean());
		
	}

	public void setService(Servicess value) {
		binder.setBean(value);
	}

}
