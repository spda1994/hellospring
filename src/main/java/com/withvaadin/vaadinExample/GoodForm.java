package com.withvaadin.vaadinExample;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.withvaadin.vaadinExample.Entity.Bidhaa;
import com.withvaadin.vaadinExample.Service.BidhaaService;

@SpringComponent
@UIScope
public class GoodForm extends VerticalLayout {

    private TextField nameField = new TextField("Name");
    private Button saveButton;
    private Bidhaa good;

    private Binder<Bidhaa> binder = new Binder<Bidhaa>(Bidhaa.class);

    private BidhaaService bidhaaService;

    public GoodForm(BidhaaService bidhaaService) {
        this.bidhaaService = bidhaaService;
        saveButton = new Button("Save", event -> save());
        build();
    }

    private void build() {
        addComponent(nameField);
        addComponent(saveButton);

        binder.forField(nameField).bind(good -> good.getgoodsName(), (good, name) -> good.setgoodsName(name));

    }

    private void save() {
        if (binder.isValid()) {
            bidhaaService.addNewData(binder.getBean());
        }
    }

    public void setGood(Bidhaa good) {
        this.good = good;
        binder.setBean(good);
    }
}
