package com.company.spring_application.database_helpers;

import org.hibernate.SessionFactory;

public abstract class AbstractSessionHolder {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
