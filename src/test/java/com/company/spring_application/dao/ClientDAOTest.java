package com.company.spring_application.dao;

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

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath:web.xml")
@ContextConfiguration("classpath:spring_config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientDAOTest implements JdbcDaoTestInterface {

    ClientDAO dao;
    Client referenceClient;

    @Autowired
    WebApplicationContext context;

    @Before
    public void init() {
        dao = (ClientDAO) context.getBean("clientDao");
        referenceClient = new Client();
    }

    @Override
    @Test
    public void aSavingWasSuccesful() {
        dao.save(new Client());
        Client client = dao.get(dao.getLastId());
        assertTrue(client.getFirstName().equals(referenceClient.getFirstName()));
        assertTrue(referenceClient.getLastName().equals(client.getLastName()));
    }

    @Override
    @Test
    public void bDeletingWasSuccessful() {
        dao.save(referenceClient);
        int before = dao.getAll().size();
        dao.delete(dao.getLastId());
        Assert.assertTrue(dao.getAll().size() < before);
    }

    @Override
    @Test
    public void cUpdatingWasSuccessful() {
        int last = dao.getLastId();
        if (last <= 0) {
            dao.save(referenceClient);
            last = dao.getLastId();
        }
        dao.update(new Client("Upd", "Upd"), last);
        Client client = dao.get(last);
        assertTrue(client.getLastName().equals("Upd"));
        assertTrue(client.getFirstName().equals("Upd"));
    }

    @Override
    @Test
    public void dGetAllReturnsProperValues() {
        int beforeSize = dao.getAll().size();
        dao.save(referenceClient);
        dao.save(referenceClient);
        assertTrue((dao.getAll().size() - beforeSize) == 2);
    }

    @Override
    @Test
    public void eGetLastIdWorksCorrectly() {
        int before = dao.getLastId();
        dao.save(referenceClient);
        int after = dao.getLastId();
        assertTrue((after - before) == 1);
    }
}