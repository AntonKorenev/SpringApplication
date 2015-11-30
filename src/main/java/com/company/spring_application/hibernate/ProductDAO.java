package com.company.spring_application.hibernate;

import com.company.spring_application.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

public class ProductDAO {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Transactional
    public void saveProduct(Product product){
        Session session=sessionFactory.openSession();
        Transaction t=session.beginTransaction();
        session.save(product);
        t.commit();
        session.close();
    }
}
