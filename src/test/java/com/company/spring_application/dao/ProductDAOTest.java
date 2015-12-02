package com.company.spring_application.dao;

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
    public void init() {
        dao = (ProductDAO) context.getBean("productDao");
    }

    @Test
    public void productGettingPFormDatabaseWasSuccessfu() throws Exception {
        System.out.println(dao.getAll());
    }

    @Test
    public void productSavingToDatabaseWasSuccessful() {
        System.out.println(dao.save(new Product(10, 100500, "Something")));
    }

    @Test
    public void productGetingByNameWasSuccessful() {
        System.out.println(dao.getById(10));
    }

    @Test
    public void productUpdatingWasSuccessful() {
        dao.updateClient(new Product(10, 100500, "Some"));
        System.out.println(dao.getAll());
    }

    @Test
    public void productDeletingFromDatabaseWasSuccessful() {
        dao.deleteClient(new Product(10, 100500, "Some"));
        System.out.println(dao.getAll());
    }
}