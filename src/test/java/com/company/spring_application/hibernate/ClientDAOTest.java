package com.company.spring_application.hibernate;

import com.company.spring_application.domain.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath:web.xml")
@ContextConfiguration("classpath:spring_config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientDAOTest {
    ClientDAO dao;
    Client referenceClient;

    @Autowired
    WebApplicationContext context;

    @Before
    public void init() {
        dao = (ClientDAO) context.getBean("clientHibernateDao");
        referenceClient = new Client();
    }

    @Test
    public void aSavingWasSuccessful() {
        dao.save(referenceClient);
        Client client = dao.getLast();
        Assert.assertEquals(client.getFirstName(), referenceClient.getFirstName());
        Assert.assertEquals(client.getLastName(), referenceClient.getLastName());
    }

    @Test
    public void bGettingAllWasSuccesful() {
        int before = dao.getAll().size();
        dao.save(referenceClient);
        dao.save(referenceClient);
        int after = dao.getAll().size();
        Assert.assertTrue((after-before)==2);
    }

    @Test
    public void cDeletingWasSuccesful() {
        dao.save(referenceClient);
        int last = dao.getLast().getId();
        dao.delete(last);
        Assert.assertNull(dao.get(last));
    }
}