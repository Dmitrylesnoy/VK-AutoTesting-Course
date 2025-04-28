package org.example.okmsger.pages;

import java.util.logging.Logger;

public abstract class Page {
    protected static final Logger logger = Logger.getLogger(Page.class.getName());

    public abstract String getUrl();

    public abstract Page open();

    public abstract void isLoaded();
}