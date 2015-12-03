package com.company.spring_application.dao;

import com.company.spring_application.domain.Client;
import com.company.spring_application.domain.Order;
import com.company.spring_application.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath:web.xml")
@ContextConfiguration("classpath:spring_config.xml")
public class OrderDAOTest implements JdbcDaoTestInterface {
    OrderDAO dao;
    Order referenceOrder;

    @Autowired
    WebApplicationContext context;

    @Before
    public void init() throws Exception {
        dao = (OrderDAO) context.getBean("orderDao");
        List<Product> list = new LinkedList<>();
        Product product = new Product();
        Client client = new Client();
        list.add(product);
        referenceOrder = new Order(new Client(), "buy", list);
        product.setOrder(referenceOrder);
        client.setOrder(referenceOrder);
    }

    @Override
    @Test
    public void aSavingWasSuccesful() throws Exception {
        dao.save(referenceOrder);
        Order order = dao.get(dao.getLastId());
        Assert.assertTrue(order.getClient().getLastName().equals(referenceOrder.getClient().getLastName()));
        Assert.assertTrue(order.getTaskDescription().equals(referenceOrder.getTaskDescription()));
    }

    @Override
    @Test(expected = org.springframework.dao.EmptyResultDataAccessException.class)
    public void bDeletingWasSuccessful() throws Exception {
        int last = dao.getLastId();
        dao.delete(last);
        Assert.assertNull(dao.get(last));
    }

    @Override
    @Test
    public void cUpdatingWasSuccessful() throws Exception {
        System.out.println("There is no 'update' method yet");
    }

    @Override
    @Test
    public void dGetAllReturnsProperValues() throws Exception {
        int beforeSize = dao.getAll().size();
        dao.save(referenceOrder);
        dao.save(referenceOrder);
        Assert.assertTrue((dao.getAll().size() - beforeSize) == 2);
    }

    @Override
    @Test
    public void eGetLastIdWorksCorrectly() throws Exception {
        int before = dao.getLastId();
        dao.save(referenceOrder);
        int after = dao.getLastId();
        Assert.assertTrue((after - before) == 1);
    }
}