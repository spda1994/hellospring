package com.withvaadin.vaadinExample;

import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.withvaadin.vaadinExample.entity.Goods;

import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class GoodsPanel extends VerticalLayout{
	Label title;

    private Button newButton , deleteAllBtn ;
    
	private GoodsGrid goodsGrid;

    @Autowired
    public GoodsPanel(GoodsGrid goodsGrid) {
        this.goodsGrid = goodsGrid;

        newButton = new Button("New", FontAwesome.PLUS);
        deleteAllBtn = new Button("Delete All", FontAwesome.TRASH_O);
        title= new Label("YOUR PREVIOUS GOODS REPORT");
        build();
    }

    private void build() {
        newButton.setWidth("200px");
        newButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        deleteAllBtn.setWidth("200px");
        deleteAllBtn.setStyleName(ValoTheme.BUTTON_DANGER);
        title.setStyleName(ValoTheme.LABEL_H3);
        addComponent(title);
        setComponentAlignment(title, Alignment.TOP_CENTER);
        HorizontalLayout buttons = new HorizontalLayout(newButton, deleteAllBtn);
        
        addComponent(buttons);
        
        goodsGrid.setSizeFull();
        addComponent(goodsGrid);
        setExpandRatio(goodsGrid,1);
    }

    public Button getNewButton() {
        return newButton;
    }

    public GoodsGrid getGoodsGrid() {
        return goodsGrid;
    }
    
    public Button getDeleteAllBtn() {
		return deleteAllBtn;
	}
}
