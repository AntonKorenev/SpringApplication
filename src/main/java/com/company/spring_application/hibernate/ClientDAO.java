package com.company.spring_application.hibernate;

import com.company.spring_application.database_helpers.AbstractSessionHolder;
import com.company.spring_application.database_helpers.HibernateDAOInterface;
import com.company.spring_application.domain.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ClientDAO extends AbstractSessionHolder implements HibernateDAOInterface<Client> {
    @Override
    public void delete(int id) {
        Client deleting = get(id);
        Session session = getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(deleting);
        t.commit();
        session.close();
    }

    @Override
    public void save(Client saving) {
        Session session = getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(saving);
        t.commit();
        session.close();
    }

    @Override
    public Client get(int id) {
        return (Client) getSessionFactory().openSession()
                .createCriteria(Client.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Client> getAll() {
        Session session = getSessionFactory().openSession();
        List<Client> products = session.createCriteria(Client.class).list();
        session.close();
        return products;
    }

    @Override
    public Client getLast(){
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from clients order by id DESC");
        query.setMaxResults(1);
        Client last = (Client) query.uniqueResult();
        session.close();
        return last;
    }
}
