package ru.systemoteh.educationportal.prim.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

public class RootContext implements WebApplicationInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootContext.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LOGGER.info("Web application 'EducationPortal' initialized");
    }
}
