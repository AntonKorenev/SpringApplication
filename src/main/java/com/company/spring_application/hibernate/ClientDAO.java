package com.company.spring_application.hibernate;

import com.company.spring_application.domain.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
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
        session.saveOrUpdate(client);
        t.commit();
        session.close();
    }

    @Transactional
    public Client getClient(int id){
        Session session = sessionFactory.openSession();
        Client client = (Client)session.createCriteria(Client.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
        session.close();
        return client;
    }

    @Transactional
    public List<Client> getAll(){
        Session session = sessionFactory.openSession();
        List<Client> clients = session.createCriteria(Client.class).list();
        session.close();
        return clients;
    }

    @Transactional
    public int deleteClient(int id){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("delete from clients where id = :ID");
        query.setParameter("ID", id);
        int result = query.executeUpdate();
        session.close();
        return result;
    }
}
