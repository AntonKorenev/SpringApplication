package com.company.spring_application.hibernate;

import com.company.spring_application.databasehelpers.AbstractSessionHolder;
import com.company.spring_application.databasehelpers.HibernateDAOInterface;
import com.company.spring_application.domain.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class OrderDAO extends AbstractSessionHolder implements HibernateDAOInterface<Order> {
    @Override
    public void delete(int id) {
        Order deleting = get(id);
        Session session=getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        session.delete(deleting);
        t.commit();
        session.close();
    }

    @Override
    public void save(Order saving) {
        Session session=getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        session.save(saving);
        t.commit();
        session.close();
    }

    @Override
    public Order get(int id) {
        Session session = getSessionFactory().openSession();
        Order order = (Order)session.createCriteria(Order.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
        session.close();
        return order;
    }

    @Override
    public List<Order> getAll() {
        Session session = getSessionFactory().openSession();
        List<Order> orders = session.createCriteria(Order.class).list();
        session.close();
        return orders;
    }
}
