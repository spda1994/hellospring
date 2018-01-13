package com.withvaadin.vaadinExample;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI()
@Theme(ValoTheme.THEME_NAME)
public class MainUI extends UI{

    private MainScreen mainScreen;

    public MainUI(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(mainScreen);
    }
}
