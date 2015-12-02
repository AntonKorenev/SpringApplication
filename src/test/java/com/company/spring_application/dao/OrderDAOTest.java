package com.company.spring_application.dao;

import com.company.spring_application.domain.Client;
import com.company.spring_application.domain.Order;
import com.company.spring_application.domain.Product;
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
public class OrderDAOTest {
    OrderDAO dao;

    @Autowired
    WebApplicationContext context;

    @Before
    public void init() throws Exception {
        dao = (OrderDAO) context.getBean("orderDao");
    }

    @Test
    public void gettingAllOrdersWasSuccessful() throws Exception {
        System.out.println(dao.getAll());
    }

    @Test
    public void orderSavingWasSuccessful() throws Exception {
        List<Product> list = new LinkedList<>();
        Product product = new Product();
        Client client = new Client();
        list.add(product);
        Order order = new Order(new Client(), "buy", list);
        product.setOrder(order);
        client.setOrder(order);
        dao.saveOrder(order);
        System.out.println(dao.getAll());
    }

    @Test
    public void orderDeletingWasSuccessful() throws Exception {
        dao.getAll();
        dao.deleteOrder(12);
        dao.getAll();
    }
}