package com.company.spring_application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SpringApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_config.xml");
        sce.getServletContext().setAttribute("spring_config", ac);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
