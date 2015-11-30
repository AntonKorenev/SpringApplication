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
        dao=(OrderDAO)context.getBean("orderDao");
    }

    @Test
    public void gettingAllOrdersWasSuccessful() throws Exception {
        System.out.println(dao.getAll());
    }

    @Test
    public void orderSavingWasSuccessful() throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product(1,1000,"router"));
        products.add(new Product(11,2345,"PC"));
        dao.saveOrder(new Order(12,new Client("Somebody","Something"),"buy",products));
        System.out.println(dao.getAll());
    }

    @Test
    public void orderDeletingWasSuccessful() throws Exception {
        dao.getAll();
        dao.deleteOrder(12);
        dao.getAll();
    }
}