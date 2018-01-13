package com.withvaadin.vaadinExample;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.DateToSqlDateConverter;
import com.vaadin.data.converter.LocalDateToDateConverter;
import com.vaadin.data.converter.StringToDateConverter;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;
import com.withvaadin.vaadinExample.Entity.Bidhaa;
import com.withvaadin.vaadinExample.Service.BidhaaService;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;

@SpringUI(path = "/previous")
@Theme("valo")
public class MyExpensesUI extends UI {

    @Autowired
    BidhaaService bidhaaservice;

    private Bidhaa bidhaa;
    Binder<Bidhaa> binder = new Binder<>(Bidhaa.class);
    VerticalLayout content2;

    VerticalLayout content1;

    HorizontalLayout headerLayout;

    VerticalLayout footerLayout;


    @Override
    protected void init(VaadinRequest request) {
        setUplayout();

    }

    private void setUplayout() {

        //window main layout
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        //header
        addHeader();

        //content body
        VerticalSplitPanel contentLayout = new VerticalSplitPanel();
        contentLayout.setSizeFull();

        //embed this to panel
        Panel bodypanel = new Panel(contentLayout);
        bodypanel.setSizeFull();

        //content 1
        content1 = new VerticalLayout();
        Label l1 = new Label(" content 1");
        content1.addComponent(l1);
        content1.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        //content 2
        /*VerticalLayout*/
        content2 = new VerticalLayout();
        Label l2 = new Label(" content 2");
        content2.addComponent(l2);
        content2.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        //embed to contentlayout
        contentLayout.setFirstComponent(content1);
        contentLayout.setSecondComponent(content2);


        //footer
        addFooter();

        //adding all components to main window
        mainLayout.addComponents(headerLayout, bodypanel, footerLayout);
        mainLayout.setExpandRatio(bodypanel, 1);
        setContent(mainLayout);
    }

    public void addFooter() {
        footerLayout = new VerticalLayout();

        Button bidhaa = new Button("Bidhaa", e -> showPreviousBidhaaReport());
        bidhaa.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);


        Button huduma = new Button("Huduma");
        huduma.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);

        HorizontalLayout buttonContainer = new HorizontalLayout(bidhaa, huduma);
        buttonContainer.setMargin(false);
        buttonContainer.setSpacing(false);

        HorizontalLayout footerLayout1 = new HorizontalLayout(new Label("Niafikra-Pae @All rights reserved"));

        footerLayout.addComponents(buttonContainer, footerLayout1);
        footerLayout.setSpacing(false);
        footerLayout.setMargin(false);
        footerLayout.setExpandRatio(buttonContainer, 1);
        footerLayout.setComponentAlignment(buttonContainer, Alignment.TOP_CENTER);
        footerLayout.setComponentAlignment(footerLayout1, Alignment.BOTTOM_CENTER);


    }

    private void addHeader() {
        headerLayout = new HorizontalLayout();
        Label title = new Label("MyExpenses");
        headerLayout.addComponent(title);
        headerLayout.setComponentAlignment(title, Alignment.TOP_CENTER);

    }

    public void showPreviousBidhaaReport() {


        if (content1.getComponentCount() == 1){
            //Display previous report

            Button addNew = new Button("Add New", e -> addNewInfo());
            addNew.setStyleName(ValoTheme.BUTTON_PRIMARY);

            content1.addComponent(addNew);
            content1.setComponentAlignment(addNew, Alignment.TOP_RIGHT);

            //Binder<Bidhaa> binder = new Binder<>(Bidhaa.class);

            Grid<Bidhaa> gridB = new Grid<>(Bidhaa.class);
            gridB.setItems(bidhaaservice.getAll());
            gridB.setColumns("id", "goodsName", "goodsAmount", "time");
            gridB.setSizeFull();

            content1.addComponent(gridB);
        }



        //binder.bindInstanceFields(this); // No instance to bind; lead to error

    }

    public void addNewInfo() {

        //add new product information
        TextField bidhaaName = new TextField("Andika jina la Bidhaa");
        bidhaaName.setWidth("40%");

        TextField bidhaaBei = new TextField("Andika Bei ya Bidhaa");
        bidhaaBei.setWidth("40%");

        DateField bidhaaTarehe = new DateField("Andika Tarehe");
        bidhaaTarehe.setValue(LocalDate.now());
        bidhaaTarehe.setWidth("40%");

        //Button save = new Button("Save", e ->submitBidhaaData());
        Button save = new Button("seve");
        save.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                bidhaaservice.addNewData(bidhaa);
                showPreviousBidhaaReport();

            }
        });
        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);

        Button cancel = new Button("Cancel");
        cancel.setStyleName(ValoTheme.BUTTON_DANGER);
        HorizontalLayout btnContainer = new HorizontalLayout(save, cancel);
        //btnContainer.setWidth("40%");

        binder.bind(bidhaaName, Bidhaa::getgoodsName, Bidhaa::setgoodsName);
        binder.forField(bidhaaBei).withConverter(new StringToDoubleConverter("shouls be number")).bind(Bidhaa::getGoodsAmount, Bidhaa::setGoodsAmount);
        binder.forField(bidhaaTarehe).withConverter(new LocalDateToDateConverter()).bind(Bidhaa::getTime, Bidhaa::setTime);
        //binder.bindInstanceFields(this);
        btnContainer.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);
        btnContainer.setComponentAlignment(cancel, Alignment.BOTTOM_RIGHT);
        btnContainer.setComponentAlignment(save, Alignment.MIDDLE_RIGHT);
        btnContainer.setMargin(false);
        btnContainer.setSpacing(false);
        content2.addComponents(bidhaaName, bidhaaBei, bidhaaTarehe, btnContainer);
        bidhaaName.focus();
    }

	/*private void submitBidhaaData() {
		bidhaaservice.addNewData(bidhaa);
		showPreviousBidhaaReport();
	}*/

}
