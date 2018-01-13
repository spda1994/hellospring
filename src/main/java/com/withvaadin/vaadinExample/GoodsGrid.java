package com.withvaadin.vaadinExample;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import com.withvaadin.vaadinExample.Entity.Bidhaa;

@SpringComponent
@UIScope
public class GoodsGrid extends Grid<Bidhaa>{

    public GoodsGrid() {
        build();
    }

    private void build() {
        addColumn(bidhaa -> bidhaa.getgoodsName().toUpperCase()).setId("name").setCaption("Name");
        addColumn(bidhaa -> bidhaa.getGoodsAmount()).setId("amount").setCaption("Amount Sold");
        addColumn(bidhaa -> bidhaa.getTime()).setId("time").setCaption(" When was it?");
    }
}
