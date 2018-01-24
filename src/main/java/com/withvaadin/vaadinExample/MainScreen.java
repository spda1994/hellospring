package com.withvaadin.vaadinExample;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.withvaadin.vaadinExample.entity.Goods;
import com.withvaadin.vaadinExample.entity.Servicess;
import com.withvaadin.vaadinExample.service.GoodsService;
import com.withvaadin.vaadinExample.service.ServicessService;

@SpringComponent
@UIScope
public class MainScreen extends VerticalLayout{

    private Button goodsButton,servicesButton;
    private HorizontalSplitPanel base;
    private GoodsPanel goodsPanel;
    private GoodForm goodForm;
	private ServicePanel servicePanel;
	private ServiceForm serviceForm;
	private GoodsService goodsService;
	private GoodsEditor goodsEditor;
	private ServiceEditor serviceEditor;
	private ServicessService servicessService;
	
	@Autowired
    public MainScreen(ServicessService servicessService, ServiceEditor serviceEditor, GoodsEditor goodsEditor, GoodsPanel goodsPanel, GoodForm goodForm, ServiceForm serviceForm, ServicePanel servicePanel, GoodsService goodsService) {
        this.goodsPanel = goodsPanel;
        this.goodForm = goodForm;
        this.goodsService=goodsService;
        this.goodsEditor = goodsEditor;
        this.serviceEditor = serviceEditor;
        this.servicessService = servicessService;
        
        this.serviceForm = serviceForm;
        this.servicePanel = servicePanel;

        base = new HorizontalSplitPanel();

        goodsButton = new Button("Goods");
        servicesButton = new Button("Services");
        build();
    }

    private void build(){
        setSizeFull();
        setMargin(true);
        
        HorizontalLayout header = new HorizontalLayout();
        Label label=new Label("This is header This is header v This is header This is header This is header This is header This is header This is header");
        header.addComponent(label);
        
        addComponent(header);

        addComponent(base);
        setExpandRatio(base,1);

        base.setFirstComponent(new Label("First"));
        base.setSecondComponent(new Label("Second"));
        

        HorizontalLayout footer = new HorizontalLayout();
        goodsButton.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        servicesButton.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        footer.addComponent(goodsButton);
        goodsButton.addClickListener(event -> showGoodsList());
        footer.addComponent(servicesButton);
        servicesButton.addClickListener(event -> showServiceList());

        addComponent(footer);
        setComponentAlignment(footer,Alignment.MIDDLE_CENTER);

        goodsPanel.setSizeFull();
        goodsPanel.getNewButton().addClickListener(event -> showNewGoodsFormg());
        
        goodsPanel.getDeleteAllBtn().addClickListener( e -> removelAllGoodesHistory());
        
        goodsPanel.getGoodsGrid().asSingleSelect().addValueChangeListener(
        		event -> {
        	goodsEditor.setGoods(event.getValue());
        	base.setSecondComponent(goodsEditor);
        	base.setWidth("140%");
        	}
        		
        		);
        goodsEditor.setSizeFull();
        
        servicePanel.setSizeFull();
        servicePanel.getNewButton().addClickListener(event -> showNewServiceform());
        servicePanel.getDeleteAll().addClickListener( e -> removeAllServiceHistory());
        servicePanel.getServiceGrid().asSingleSelect().addValueChangeListener(
        		e -> {
        			serviceEditor.setService(e.getValue());
        			base.setSecondComponent(serviceEditor);
        			base.setWidth("140%");
        		}
        		);
        serviceEditor.setSizeFull();
    }

    private void removelAllGoodesHistory() {
    	goodsService.removeAll();
	
	}
    
    private void removeAllServiceHistory() {
    	servicessService.removeAll();
    }

	private void showNewGoodsFormg() {
    	goodForm.setGood(new Goods());
        base.setSecondComponent(goodForm);
        base.setWidth("140%");
	}

	private void showNewServiceform() {
		serviceForm.setService(new Servicess());
		base.setSecondComponent(serviceForm);
		base.setWidth("140%");
	}

	private void showServiceList() {
		base.setFirstComponent(servicePanel);
		base.setWidth("200%");
		base.setSecondComponent(null);
	}

	/*private void showNewGoodsForm(Goods goods) {
        goodForm.setGood(goods);
        base.setSecondComponent(goodForm);
    }*/

    private void showGoodsList() {
        base.setFirstComponent(goodsPanel);
        base.setWidth("200%");
        base.setSecondComponent(null);
    }

//    private void showServices() {
//        base.setFirstComponent(serviicesPanel);
//    }
}
