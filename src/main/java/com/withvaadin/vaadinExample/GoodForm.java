package com.withvaadin.vaadinExample;

import java.time.LocalDate;
import java.util.Date;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.LocalDateToDateConverter;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.withvaadin.vaadinExample.entity.Goods;
import com.withvaadin.vaadinExample.service.GoodsService;

@SpringComponent
@UIScope
public class GoodForm extends VerticalLayout {

    private TextField nameField = new TextField("Name");
    private TextField amount=new TextField("Amount");
    private DateField dateField=new DateField("Time created");
    private Button saveButton;
    private Label title;
    
    private Goods goods;
    
    private Binder<Goods> binder = new Binder<Goods>(Goods.class);

    private GoodsService goodsService;

    public GoodForm(GoodsService goodsService) {
        this.goodsService = goodsService;
        title=new Label("RECORD YOUR NEW EXPENSES");
        saveButton = new Button("Save", FontAwesome.SAVE);
         saveButton.addClickListener( e -> save());
        build();
    }

	private void build() {
		
		title.setStyleName(ValoTheme.LABEL_H3);
		addComponent(title);
		setComponentAlignment(title, Alignment.TOP_LEFT);
		
        addComponent(nameField);
        addComponent(amount);
        
        dateField.setValue(LocalDate.now());
        dateField.setDateFormat("dd/MM/yyyy"); //ISO format
        addComponent(dateField);
        addComponent(saveButton);
        saveButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
         
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
       // binder.bindInstanceFields(this);

        binder.forField(nameField).bind(good -> good.getgoodsName(), (good, name) -> good.setgoodsName(name));
        binder.forField(amount).withConverter(new StringToDoubleConverter("Must be a number")).bind(Goods::getGoodsAmount, Goods::setGoodsAmount);
        binder.forField(dateField).withConverter(new LocalDateToDateConverter()).bind(Goods::getTime,Goods::setTime);
        
        
    }

    public void save() {
        if (binder.isValid()) {
            goodsService.addNewData(binder.getBean());
         
        }
    }

    public void setGood(Goods good) {
        this.goods = good;
        binder.setBean(good);
        
    }
    
}
