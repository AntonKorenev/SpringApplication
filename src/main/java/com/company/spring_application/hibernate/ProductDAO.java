package com.company.spring_application.hibernate;

import com.company.spring_application.domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        session.saveOrUpdate(product);
        t.commit();
        session.close();
    }

    @Transactional
    public Product getProduct(int id){
        return (Product)sessionFactory.openSession()
                .createCriteria(Product.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
    }

    @Transactional
    public List<Product> getAll(){
        Session session = sessionFactory.openSession();
        List<Product> products = session.createCriteria(Product.class).list();
        session.close();
        return products;
    }

    @Transactional
    public int deleteProduct(int id){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("delete from products where id = :ID");
        query.setParameter("ID", id);
        int result = query.executeUpdate();
        session.close();
        return result;
    }
}
