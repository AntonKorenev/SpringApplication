package com.company.spring_application.hibernate;

import com.company.spring_application.domain.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        session.saveOrUpdate(order);
        t.commit();
        session.close();
    }

    @Transactional
    public List<Order> getAll(){
        Session session = sessionFactory.openSession();
        List<Order> orders = session.createCriteria(Order.class).list();
        session.close();
        return orders;
    }

    @Transactional
    public Order getOrder(int id){
        Session session = sessionFactory.openSession();
        Order order = (Order)session.createCriteria(Order.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
        session.close();
        return order;
    }

    @Transactional
    public int deleteOrder(int id){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("delete from orders where id = :ID");
        query.setParameter("ID", id);
        int result = query.executeUpdate();
        session.close();
        return result;
    }
}
