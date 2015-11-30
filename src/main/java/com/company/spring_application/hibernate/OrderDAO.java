package com.company.spring_application.hibernate;

import com.company.spring_application.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

public class OrderDAO {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Transactional
    public void saveOrder(Order order){
        Session session=sessionFactory.openSession();
        Transaction t=session.beginTransaction();
        session.persist(order);
        t.commit();
        session.close();
    }
}
