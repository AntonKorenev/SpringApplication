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
    Client ethalonClient;

    @Autowired
    WebApplicationContext context;

    @Before
    public void init(){
        dao=(ClientDAO) context.getBean("clientHibernateDao");
        ethalonClient = (Client)context.getBean("client");
    }

    @Test
    public void aSavingWasSuccessful(){
        dao.save(ethalonClient);
        Client client = dao.get(1);
        Assert.assertEquals(client.getFirstName(),ethalonClient.getFirstName());
        Assert.assertEquals(client.getLastName(),ethalonClient.getLastName());
    }

    @Test
    public void bGettingAllWasSuccesful(){
        Client client = dao.getAll().get(0);

        Assert.assertEquals(client.getFirstName(),ethalonClient.getFirstName());
        Assert.assertEquals(client.getLastName(),ethalonClient.getLastName());
    }

    @Test
    public void cDeletingWasSuccesful(){
        dao.delete(1);
        Assert.assertNull(dao.get(1));
    }
}