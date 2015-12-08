package com.company.spring_application.hibernate;

import com.company.spring_application.database_helpers.AbstractSessionHolder;
import com.company.spring_application.database_helpers.HibernateDAOInterface;
import com.company.spring_application.domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ProductDAO extends AbstractSessionHolder implements HibernateDAOInterface<Product> {
    @Override
    public void delete(int id) {
        Product deleting = get(id);
        Session session = getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(deleting);
        t.commit();
        session.close();
    }

    @Override
    public void save(Product saving) {
        Session session = getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(saving);
        t.commit();
        session.close();
    }

    @Override
    public Product get(int id) {
        return (Product) getSessionFactory().openSession()
                .createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Product> getAll() {
        Session session = getSessionFactory().openSession();
        List<Product> products = session.createCriteria(Product.class).list();
        session.close();
        return products;
    }

    @Override
    public Product getLast(){
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from products order by id DESC");
        query.setMaxResults(1);
        Product last = (Product) query.uniqueResult();
        session.close();
        return last;
    }
}
