/*package com.withvaadin.vaadinExample;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.withvaadin.vaadinExample.View.BidhaaView;

@SpringUI
@Theme("valo")
public class MatumiziUI extends UI{
	
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 4695716008783202358L;
	private VerticalLayout layout;
	private VerticalLayout contentLayout;

 @Override
	protected void init(VaadinRequest request) {
		setUpLayout();
		addTitle();
		//addGrid();
		addForm();
		addTodoList();
		//addActionButton();
	}

	private void addForm() {
		
		// kianzio
		Label title = new Label("Kianzio(Tsh:)");
		TextField kianzio = new TextField();
		Button ok = new Button("OK");
		ok.setStyleName(ValoTheme.BUTTON_PRIMARY);
		HorizontalLayout kianzisave = new HorizontalLayout();
		kianzisave.addComponents(title,kianzio,ok);
		//kianzisave.setSpacing(true);
		kianzisave.setWidth("80%");
		kianzisave.setExpandRatio(kianzio, 1);
		kianzio.setWidth("100%");
		
		
		//huduma
		Button huduma=new Button("Huduma");
		huduma.setWidth("80%");
		huduma.addClickListener(new ClickListener() {
			 
		      @Override
		      public void buttonClick(ClickEvent event) {
		 
		        setContent(new BidhaaView());
		      }
		    });
		
		
		//bidhaa
		// pop up layout
		VerticalLayout popupcontent = new VerticalLayout();
		
		//components
		TextField bidhaaName = new TextField("Andika jina la Bidhaa");
		TextField bidhaaBei = new TextField("Andika Bei ya Bidhaa");
		DateField bidhaaTarehe = new DateField("Andika Tarehe");
		bidhaaTarehe.setValue(LocalDate.now());
		
		//button grouping layout
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setSpacing(true);
		//buttonLayout.setWidth("100%");
		Button save= new Button("SAVE");
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		Button cancel = new Button("CANCEL");
		cancel.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		buttonLayout.addComponents(save,cancel);
		popupcontent.addComponents(bidhaaName,bidhaaBei,bidhaaTarehe,buttonLayout);
		//
		popupcontent.setComponentAlignment(buttonLayout, Alignment.MIDDLE_CENTER);
		popupcontent.setComponentAlignment(bidhaaName, Alignment.MIDDLE_CENTER);
		popupcontent.setComponentAlignment(bidhaaBei, Alignment.MIDDLE_CENTER);
		popupcontent.setComponentAlignment(bidhaaTarehe, Alignment.MIDDLE_CENTER);
		popupcontent.setSizeFull();
		
		//pop up class
		@SuppressWarnings("deprecation")
		PopupView popup = new PopupView("BIDHAA", popupcontent);
		Button bidhaa=new Button("Bidhaa", event->event.getButton().setCaption("mama pae"));
		bidhaa.setWidth("80%");
		contentLayout.addComponents(kianzisave,popup,huduma);
		
		
	
}

	private void setUpLayout() {
		//	HEADER
		final VerticalLayout headerLayout=new VerticalLayout();
		final HorizontalLayout menu=new HorizontalLayout();
		Button home = new Button("HOME");
		Button about = new Button("ABOUT");
		Button contact = new Button("CONTACT");
		menu.addComponents(home,about,contact);
		menu.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		headerLayout.addComponent(menu);
		headerLayout.setMargin(false);
		headerLayout.setSpacing(true);
		headerLayout.setComponentAlignment(menu, Alignment.BOTTOM_CENTER);
		headerLayout.setStyleName("v-header");
		
		
		//FOOTER
		Label foot=new Label("all right reserved."+ new java.util.Date());
		final VerticalLayout footerLayout = new VerticalLayout(foot);
		footerLayout.setMargin(false);
		footerLayout.setSpacing(true);
		footerLayout.setComponentAlignment(foot,Alignment.BOTTOM_CENTER);
		footerLayout.setStyleName("v-footer");
		
		//BODY/CONTENT
		contentLayout = new VerticalLayout();
		contentLayout.setWidth("100%");
		contentLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		
		// PANEL to make content scrollable
		final Panel contentPanel= new Panel(contentLayout);
		contentPanel.setSizeFull();
		
		//main layout
		layout=new VerticalLayout(headerLayout, contentPanel, footerLayout);
		layout.setSizeFull(); // ensure all space is in use
		layout.setExpandRatio(contentPanel,1);
		layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		setContent(layout);
	}

	private void addTitle() {
		Label title = new Label("Kitabu cha matumizi yangu");
		title.addStyleName(ValoTheme.LABEL_H3);
		contentLayout.addComponents(title);
	}
		

	private void addGrid() {
		
	}

	private void addTodoList() {
		
		
	}

	private void addActionButton() {
		
	}

}
*/