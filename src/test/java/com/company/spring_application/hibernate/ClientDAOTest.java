package com.company.spring_application.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath:web.xml")
@ContextConfiguration("classpath:spring_config.xml")
public class ClientDAOTest {

    ClientDAO dao;

    @Autowired
    WebApplicationContext context;

    @Before
    public void init(){
        dao=(ClientDAO) context.getBean("clientHibernateDao");
    }


    @Test
    public void testSaveClient() throws Exception {
        //dao.saveClient((Client)context.getBean("client"));
        //System.out.println(dao.getClient(1));
        //System.out.println(dao.getAll());
        dao.deleteClient(6);
    }
}