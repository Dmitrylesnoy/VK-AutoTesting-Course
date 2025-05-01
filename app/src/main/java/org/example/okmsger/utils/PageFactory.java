package org.example.okmsger.utils;

import java.util.logging.Logger;

import org.example.okmsger.pages.*;

public class PageFactory {
    private static final Logger logger = Logger.getLogger(PageFactory.class.getName());

    public static Page createUrlPage(String URL) {
        try {
            logger.info("Creating page for:" + Navigator.getUrl());
            Page page = null;
            if (Navigator.isUrlEquals(URL, FeedPage.getUrl()))
                page= new FeedPage();
            if (Navigator.isUrlEquals(URL, HelpPage.getUrl()))
                page= new HelpPage();
            if (Navigator.isUrlEquals(URL, MainPage.getUrl()))
                page= new MainPage();
            if (Navigator.isUrlEquals(URL, RecoveryPage.getUrl()))
                page= new RecoveryPage();
            if (Navigator.isUrlEquals(URL, SearchPage.getUrl()))
                page= new SearchPage();
            logger.info("Creared page: "+URL);
            return page;
        } catch (Exception e) {
            logger.severe("Failed to create page");
            throw new RuntimeException("Cannot create page", e);
        }
    }
}