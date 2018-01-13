/*
package com.withvaadin.vaadinExample;

import java.util.Arrays;
import java.util.List;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
@Theme("valo")
public class MyUI extends UI{
	
	private VerticalLayout layout;
	private VerticalLayout contentLayout;
	List<Todos> todos= Arrays.asList(
			new Todos(1, "kulala","low",new java.util.Date()), 
			new Todos(1, "kulala","low",new java.util.Date()),
			new Todos(1, "kulala","low",new java.util.Date()), 
			new Todos(1, "kulala","low",new java.util.Date()),
			new Todos(1, "kulala","low",new java.util.Date()), 
			new Todos(1, "kulala","low",new java.util.Date()),
			new Todos(1, "kulala","low",new java.util.Date()), 
			new Todos(1, "kulala","low",new java.util.Date()),
			new Todos(1, "kulala","low",new java.util.Date()), */
			/*new Todos(1, "kulala","low",new java.util.Date()),
			new Todos(1, "kulala","low",new java.util.Date()), 
			new Todos(1, "kulala","low",new java.util.Date()),
			new Todos(1, "kulala","low",new java.util.Date()), 
			new Todos(1, "kulala","low",new java.util.Date()),
			new Todos(1, "kulala","low",new java.util.Date()), 
			new Todos(1, "kulala","low",new java.util.Date()),
			new Todos(1, "kulala","low",new java.util.Date()), 
			new Todos(1, "kulala","low",new java.util.Date()),
			new Todos(1, "kulala","low",new java.util.Date()), 
			new Todos(1, "kulala","low",new java.util.Date()),
			new Todos(1, "kulala","low",new java.util.Date()), 
			new Todos(1, "kulala","low",new java.util.Date()),*/
			/* new Todos(3,"kusoma","high", new java.util.Date()));

 @Override
	protected void init(VaadinRequest request) {
		setUpLayout();
		addTitle();
		addGrid();
		addTodoList();
		addActionButton();
	}

	private void setUpLayout() {
		//	HEADER
		final VerticalLayout headerLayout=new VerticalLayout(new Label("HEADER"));
		headerLayout.setMargin(true);
		headerLayout.setSpacing(true);
		headerLayout.setStyleName("v-header");
		
		
		//FOOTER
		final VerticalLayout footerLayout = new VerticalLayout(new Label("all right reserved."+ new java.util.Date()));
		footerLayout.setMargin(true);
		footerLayout.setSpacing(true);
		footerLayout.setStyleName("v-footer");
		//BODY/CONTENT
		contentLayout = new VerticalLayout();
		contentLayout.setWidth("100%");
		//contentLayout.setHeightUndefined();
		contentLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		
		// PANEL to make content scrollable
		final Panel contentPanel= new Panel(contentLayout);
		contentPanel.setSizeFull();
		//contentPanel.setHeightUndefined();
		
		//main layout
		layout=new VerticalLayout(headerLayout, contentPanel, footerLayout);
		layout.setSizeFull(); // ensure all space is in use
		layout.setExpandRatio(contentPanel,0.8f);
		layout.setExpandRatio(headerLayout,0.1f);
		layout.setExpandRatio(footerLayout,0.06f);
		layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		setContent(layout);
	}

	private void addTitle() {
		Label title = new Label("MY TODOs");
		title.addStyleName(ValoTheme.LABEL_H1);
		contentLayout.addComponents(title);
	}
		

	private void addGrid() {
		Grid<Todos> grid = new Grid<>("My table");
		grid.setItems(todos);
		grid.setWidth("94%");
		//grid.setHeightUndefined();
		grid.addColumn(Todos::getId).setCaption("ID");
		grid.addColumn(Todos::getTitle).setCaption("TITLE");
		grid.addColumn(Todos::getPriority).setCaption("PRIORITY");
		grid.addColumn(Todos::getDate).setCaption("TIME");
		contentLayout.addComponent(grid);
	}

	private void addTodoList() {
		
		
	}

	private void addActionButton() {
		final HorizontalLayout horizontal=new HorizontalLayout();
		Button addBtn = new Button();
		addBtn.setIcon(FontAwesome.PLUS);
		addBtn.setStyleName(ValoTheme.BUTTON_PRIMARY);
		Button editBtn = new Button();
		editBtn.setIcon(FontAwesome.EDIT);
		editBtn.setStyleName(ValoTheme.BUTTON_DANGER);
		horizontal.addComponents(addBtn,editBtn);
		contentLayout.addComponent(horizontal);
	}

}
*/