package com.company.spring_application.dao;

import com.company.spring_application.domain.Client;
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
    public void init() {
        dao = (ClientDAO) context.getBean("clientDao");
    }

    @Test
    public void gettingClientsFormDatabaseWasSuccessful() throws Exception {
        System.out.println(dao.getAll());
    }

    @Test
    public void savingToDatabaseWasSuccessful() {
        System.out.println(dao.save(new Client("Somebody", "Something")));
    }

    @Test
    public void gettingObjectByNameWasSuccessful() {
        System.out.println(dao.getByName("Aki"));
    }

    @Test
    public void gettingIdByClientWasSuccessful() {
        System.out.println(dao.getIdByClient(new Client("Aki", "Nomi")));
    }

    @Test
    public void objectUpdatingWasSuccessful() {
        dao.updateClient(new Client("Ivar", "Stark"), 2);
        System.out.println(dao.getAll());
    }

    @Test
    public void deletingFromDatabaseWasSuccessful() {
        dao.deleteClient(new Client("Somebody", "Something"));
        System.out.println(dao.getAll());
    }
}