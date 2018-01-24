package com.withvaadin.vaadinExample;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;

import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
@UIScope
public class ServicePanel extends VerticalLayout{
	
	private Button newButton, deleteAll;
	private ServiceGrid servicegrid;
	private Label title;

	public ServicePanel(ServiceGrid serviceGrid) {
		this.servicegrid=serviceGrid;
		newButton= new Button("New", FontAwesome.PLUS);
		deleteAll = new Button("Delete All", FontAwesome.TRASH_O);
		title= new Label("YOUR PREVIOUS SERVICES REPORT");
		build();
	}

	private void build() {
		title.setStyleName(ValoTheme.LABEL_H3);
        addComponent(title);
        setComponentAlignment(title, Alignment.TOP_CENTER);
		
		newButton.setWidth("200px");
		deleteAll.setWidth("200px");
		
		HorizontalLayout horizontalLayout=new HorizontalLayout(newButton, deleteAll);
		
		addComponent(horizontalLayout);
		addComponent(servicegrid);
		servicegrid.setSizeFull();
		setExpandRatio(servicegrid, 1);
		
	}
	
	public Button getNewButton() {
		return newButton;
	}
	
	public ServiceGrid getServiceGrid() {
		return servicegrid;
	}
	
	public Button getDeleteAll() {
		return deleteAll;
		
	}

}
