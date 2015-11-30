package com.company.spring_application.hibernate;

import com.company.spring_application.domain.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;


public class ClientDAO {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Transactional
    public void saveClient(Client client){
        Session session=sessionFactory.openSession();
        Transaction t=session.beginTransaction();
        session.persist(client);
        t.commit();
        session.close();
    }

}
