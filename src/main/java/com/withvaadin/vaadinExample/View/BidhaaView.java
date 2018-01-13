package com.withvaadin.vaadinExample.View;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

public class BidhaaView extends CustomComponent implements View {
	
	VerticalLayout verticalLayoutWindow=new VerticalLayout();
	VerticalLayout middleContent=new VerticalLayout();
	HorizontalLayout header=new HorizontalLayout();
	HorizontalLayout footer = new HorizontalLayout();
	HorizontalLayout btn = new HorizontalLayout();
	
	public BidhaaView() {
		verticalLayoutWindow.setSizeFull();
		
		TextField goodsName=new TextField("Andika Bidhaa Ulionunua");
		TextField goodsAmount=new TextField("Andika Bei ulionunulia");
		Button save=new Button("SAVE", event-> event.getButton().setCaption("saved"));
		Button cancel= new Button("CANCEL", event->event.getButton().setCaption("Canceled"));
		btn.addComponents(save, cancel);
		middleContent.addComponents(goodsName, goodsAmount,btn);
		middleContent.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		verticalLayoutWindow.addComponent(middleContent);
		//verticalLayoutWindow.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		verticalLayoutWindow.setExpandRatio(middleContent, 1);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("hallow pae de",Type.TRAY_NOTIFICATION);
		//verticalLayoutWindow.setContent();
	}

}
