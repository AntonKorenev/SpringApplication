package com.company.spring_application.hibernate;

import com.company.spring_application.domain.Client;
import com.company.spring_application.domain.Order;
import com.company.spring_application.domain.Product;
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

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath:web.xml")
@ContextConfiguration("classpath:spring_config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDAOTest {
    OrderDAO dao;
    Order referenceOrder;

    @Autowired
    WebApplicationContext context;

    @Before
    public void init() {
        dao = (OrderDAO) context.getBean("orderHibernateDao");

        List<Product> list = new LinkedList<>();
        Product product = new Product();
        Client client = new Client();
        list.add(product);
        referenceOrder = new Order(new Client(), "buy", list);
        product.setOrder(referenceOrder);
        client.setOrder(referenceOrder);
    }

    @Test
    public void aSavingWasSuccessful() {
        dao.save(referenceOrder);
        Order order = dao.getLast();
        Assert.assertEquals(order.getTaskDescription(), referenceOrder.getTaskDescription());
        Assert.assertEquals(order.getClient().getLastName(), referenceOrder.getClient().getLastName());
    }

    @Test
    public void bGettingAllWasSuccesful() {
        int before = dao.getAll().size();
        dao.save(referenceOrder);
        dao.save(referenceOrder);
        int after = dao.getAll().size();
        Assert.assertTrue((after-before)==2);
    }

    @Test
    public void cDeletingWasSuccesful() {
        dao.save(referenceOrder);
        int last = dao.getLast().getId();
        dao.delete(last);
        Assert.assertNull(dao.get(last));
    }
}