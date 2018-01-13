package com.withvaadin.vaadinExample;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.withvaadin.vaadinExample.Entity.Bidhaa;

@SpringComponent
@UIScope
public class MainScreen extends VerticalLayout{

    private Button goodsButton,servicesButton;
    private VerticalSplitPanel base;
    private GoodsPanel goodsPanel;
    private GoodForm goodForm;

    public MainScreen(GoodsPanel goodsPanel, GoodForm goodForm) {
        this.goodsPanel = goodsPanel;
        this.goodForm = goodForm;
        this.goodsPanel = goodsPanel;

        base = new VerticalSplitPanel();

        goodsButton = new Button("Goods");
        servicesButton = new Button("Services");
        build();
    }

    private void build(){
        setSizeFull();
        setMargin(true);

        addComponent(base);
        setExpandRatio(base,1);

        base.setFirstComponent(new Label("First"));
        base.setSecondComponent(new Label("Second"));

        HorizontalLayout footer = new HorizontalLayout();
        footer.addComponent(goodsButton);
        goodsButton.addClickListener(event -> showGoodsList());
        footer.addComponent(servicesButton);

        addComponent(footer);
        setComponentAlignment(footer,Alignment.MIDDLE_CENTER);

        goodsPanel.setSizeFull();
        goodsPanel.getNewButton().addClickListener(event -> showNewGoodsForm());
    }

    private void showNewGoodsForm() {
        goodForm.setGood(new Bidhaa());
        base.setSecondComponent(goodForm);
    }

    private void showGoodsList() {
        base.setFirstComponent(goodsPanel);
    }

//    private void showServices() {
//        base.setFirstComponent(serviicesPanel);
//    }
}
