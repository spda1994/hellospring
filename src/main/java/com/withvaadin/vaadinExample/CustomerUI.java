/*package com.withvaadin.vaadinExample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
public class CustomerUI extends UI{
	
	/**
	 * 
	 */
/*	private static final long serialVersionUID = -8610023375514429939L;

	@Autowired
	private CustomerService service;
	
	private Customer customer;
	
	private Binder<Customer> binder= new Binder<>(Customer.class);
	
	private Grid<Customer> grid=new Grid<>(Customer.class);
	private TextField firstName= new TextField("First Name");
	private TextField lastName= new TextField("last name");
	private Button save=new Button("save",e->saveCustomer());
	

	@Override
	protected void init(VaadinRequest request) {
		updateGrid();
		grid.setColumns("firstName","lastName");
		grid.addSelectionListener(e->updateForm());
		
		binder.bindInstanceFields(this);
		
		VerticalLayout layout = new VerticalLayout(grid, firstName,lastName, save);
		setContent(layout);
	}


	private void saveCustomer() {
		service.update(customer);
		updateGrid();
	}


	private void updateForm() {
		if(grid.asSingleSelect().isEmpty()) {
			setFormVisible(false);
		}else {
			customer=grid.asSingleSelect().getValue();
			binder.setBean(customer);
			setFormVisible(true);
		}
	}


	private void setFormVisible(boolean visible) {
		firstName.setVisible(visible);
		lastName.setVisible(visible);
		save.setVisible(visible);
		
	}

			
	private void updateGrid() {
		List<Customer> customers=service.findAll();
		grid.setItems(customers);
		setFormVisible(false);
	}

}
*/