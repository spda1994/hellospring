package com.withvaadin.vaadinExample;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.withvaadin.vaadinExample.Entity.Bidhaa;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class GoodsPanel extends VerticalLayout{

    private Button newButton;
    private GoodsGrid goodsGrid;

    @Autowired
    public GoodsPanel(GoodsGrid goodsGrid) {
        this.goodsGrid = goodsGrid;

        newButton = new Button("New");
        build();
    }

    private void build() {
        newButton.setWidth("200px");
        addComponent(newButton);
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
}
