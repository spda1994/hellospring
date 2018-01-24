package com.withvaadin.vaadinExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;

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
import com.withvaadin.vaadinExample.entity.Goods;
import com.withvaadin.vaadinExample.service.GoodsService;

@SuppressWarnings("deprecation")
@SpringComponent
@UIScope
public class GoodsEditor extends VerticalLayout{
	
	private Label title;
	
	private TextField namefield=new TextField("name of goods");
	private TextField amount = new TextField("amout used");
	private DateField dateField = new DateField("Due date");
	
	private Button save = new Button("Update", FontAwesome.SAVE);
	private Button delete = new Button("Delete", FontAwesome.TRASH_O);
	private Button cancel = new Button("Cancel");
	
	HorizontalLayout actions = new HorizontalLayout(save, delete, cancel);
	
	private Goods goods;
	private GoodsGrid goodsGrid;
	private GoodsService goodsService;
	
	Binder<Goods> binder = new Binder<Goods>(Goods.class);
	
	@Autowired
	public GoodsEditor(GoodsService goodsService, GoodsGrid goodsGrid) {
		this.goodsGrid = goodsGrid;
		this.goodsService = goodsService;
		save.addClickListener(e -> save());
		delete.addClickListener(event -> delete());
		cancel.addClickListener(e -> cancel() );
		 title=new Label("EDIT YOUR INFORMATION");
		build();
		
	}
	
	
	private void build() {
		
		//addComponents(namefield, amount, dateField, actions);
		title.setStyleName(ValoTheme.LABEL_H3);
		addComponent(title);
		setComponentAlignment(title, Alignment.TOP_LEFT);
		addComponent(namefield);
		addComponent(amount);
		addComponent(dateField);
		addComponent(actions);
		// using naming convention
		//binder.bindInstanceFields(this);
		
		 binder.forField(namefield).bind(good -> good.getgoodsName(), (good, name) -> good.setgoodsName(name));
	     binder.forField(amount).withConverter(new StringToDoubleConverter("Must be a number")).bind(Goods::getGoodsAmount, Goods::setGoodsAmount);
	     binder.forField(dateField).withConverter(new LocalDateToDateConverter()).bind(Goods::getTime,Goods::setTime);
	        
		
		//setSpacing(true);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		delete.setStyleName(ValoTheme.BUTTON_DANGER);
		cancel.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		
	}
	
	private void cancel() {
		
	}

	
	private void delete() {
		goodsService.removeOne(binder.getBean());
		goodsService.getAll();
		goodsGrid.select(binder.getBean());
	}

	private void save() {
		goodsService.update(binder.getBean());
		goodsService.getAll();
		goodsGrid.select(binder.getBean());
		
	}

	public void setGoods(Goods value) {
		binder.setBean(value);
		
	}

}
