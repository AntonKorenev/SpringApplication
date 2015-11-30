package com.company.spring_application.hibernate;

import com.company.spring_application.domain.Product;
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
public class ProductDAOTest {

    ProductDAO dao;

    @Autowired
    WebApplicationContext context;

    @Before
    public void init(){
        dao=(ProductDAO) context.getBean("productHibernateDao");
    }

    @Test
    public void testSaveProduct() throws Exception {
        dao.saveProduct((Product)context.getBean("product"));
    }
}