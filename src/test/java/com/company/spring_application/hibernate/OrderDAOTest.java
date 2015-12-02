package com.company.spring_application.hibernate;

import com.company.spring_application.domain.Client;
import com.company.spring_application.domain.Order;
import com.company.spring_application.domain.Product;
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

    @Autowired
    WebApplicationContext context;

    @Before
    public void init(){
        dao=(OrderDAO) context.getBean("orderHibernateDao");
    }

    @Test
    public void testSaveOrder() throws Exception {
        List<Product> list = new LinkedList<>();
        Product product = new Product();
        Client client = new Client();
        list.add(product);
        Order order = new Order(new Client(),"buy",list);
        product.setOrder(order);
        client.setOrder(order);
        dao.save(order);

        System.out.println(dao.get(1));
        dao.delete(1);
        System.out.println(dao.getAll());
    }
}