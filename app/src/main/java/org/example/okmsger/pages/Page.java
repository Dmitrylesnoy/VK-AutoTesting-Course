package org.example.okmsger.pages;

import java.util.logging.Logger;

import org.example.okmsger.utils.Navigator;

public abstract class Page {
    protected static final Logger logger = Logger.getLogger(Page.class.getName());

    private static final String URL = "https://ok.ru/";

    public void Page() {
        if (!Navigator.checkUrl(URL))
            open();
        
    }

    public static String getUrl() {
        return URL;
    }

    public void isLoaded(){
        logger.info("Checking if "+ URL+" page is loaded");
        Navigator.checkUrl(URL);
        validatePageElements();
        logger.info(URL+" is loaded and validated");
    };

    public abstract void validatePageElements();

    public Page open() {
        Navigator.openUrl(URL);
        isLoaded();
        return this;
    }
}