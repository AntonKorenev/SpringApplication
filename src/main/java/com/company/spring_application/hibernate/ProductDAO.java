package com.company.spring_application.hibernate;

import com.company.spring_application.databasehelpers.AbstractSessionHolder;
import com.company.spring_application.databasehelpers.HibernateDAOInterface;
import com.company.spring_application.domain.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class ProductDAO extends AbstractSessionHolder implements HibernateDAOInterface<Product> {
    @Override
    public void delete(int id) {
        Product deleting = get(id);
        Session session=getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        session.delete(deleting);
        t.commit();
        session.close();
    }

    @Override
    public void save(Product saving) {
        Session session=getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        session.save(saving);
        t.commit();
        session.close();
    }

    @Override
    public Product get(int id) {
        return (Product)getSessionFactory().openSession()
                .createCriteria(Product.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
    }

    @Override
    public List<Product> getAll() {
        Session session = getSessionFactory().openSession();
        List<Product> products = session.createCriteria(Product.class).list();
        session.close();
        return products;
    }
}
