package com.withvaadin.vaadinExample;

import java.util.Arrays;
import java.util.List;

import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Layout;

public class MyGridLayout extends GridLayout {
	List<Todos> todos= Arrays.asList(
			new Todos(1, "kulala","low",new java.util.Date()), 
			new Todos(1, "kulala","low",new java.util.Date()),
			new Todos(3,"kusoma","high", new java.util.Date()));

	public MyGridLayout() {
		super();
		this.setMargin(true);
		this.setSpacing(true);
		this.setWidthUndefined();
		this.setHeight("100%");	
		
		Grid<Todos> grid = new Grid<>("My table");
		grid.setItems(todos);
		grid.setSizeFull();
		grid.addColumn(Todos::getId).setCaption("ID");
		grid.addColumn(Todos::getTitle).setCaption("TITLE");
		grid.addColumn(Todos::getPriority).setCaption("PRIORITY");
		grid.addColumn(Todos::getDate).setCaption("TIME");
		this.addComponent(grid);
	}
}