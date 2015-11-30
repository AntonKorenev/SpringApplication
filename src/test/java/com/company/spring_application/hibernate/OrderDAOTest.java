package com.company.spring_application.hibernate;

import com.company.spring_application.domain.Order;
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
        com.company.spring_application.dao.ClientDAO clientDAO = (com.company.spring_application.dao.ClientDAO) context.getBean("clientDao");
        com.company.spring_application.dao.ProductDAO productDAO = (com.company.spring_application.dao.ProductDAO) context.getBean("productDao");
        Order order = new Order(10,clientDAO.getById(3),"rent",productDAO.getById(3));

        dao.saveOrder(order);
        //System.out.println(dao.getAll());
        //System.out.println(dao.getOrder(3));
    }
}