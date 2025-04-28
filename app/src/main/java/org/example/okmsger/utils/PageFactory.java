package org.example.okmsger.utils;

import org.example.okmsger.pages.*;
import java.util.logging.Logger;

public class PageFactory {
    private static final Logger logger = Logger.getLogger(PageFactory.class.getName());

    public static <T extends Page> T createPage(Class<T> pageClass) {
        try {
            logger.info("Creating page: " + pageClass.getSimpleName());
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            logger.severe("Failed to create page " + pageClass.getSimpleName() + ": " + e.getMessage());
            throw new RuntimeException("Cannot create page: " + pageClass.getSimpleName(), e);
        }
    }
}