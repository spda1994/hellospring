package com.withvaadin.vaadinExample;

import java.util.Collection;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import com.withvaadin.vaadinExample.entity.Goods;
import com.withvaadin.vaadinExample.service.GoodsService;

@SpringComponent
@UIScope
public class GoodsGrid extends Grid<Goods>{
	
	GoodsService goodsService;

    public GoodsGrid(GoodsService goodsService) {
    	this.goodsService = goodsService;
        build();
    }

    private void build() {
    	addColumn(Goods::getId).setCaption("sNo");
        addColumn(Goods::getgoodsName).setCaption("Name");
        addColumn(Goods::getGoodsAmount).setCaption("Amount Sold");
        addColumn(bidhaa -> bidhaa.getTime()).setId("time").setCaption(" When was it?");
        setItems(listGoods());
    }

	private Collection<Goods> listGoods() {
		return goodsService.getAll();
	}
}
