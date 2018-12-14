package ru.systemoteh.educationportal.prim.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RootContext implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootContext.class);


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("Web application 'EducationPortal' initialized");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("Web application 'EducationPortal' destroyed");
    }


}
