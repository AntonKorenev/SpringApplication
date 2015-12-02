package com.company.spring_application.hibernate;

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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath:web.xml")
@ContextConfiguration("classpath:spring_config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDAOTest {
    ProductDAO dao;
    Product ethalonProduct;

    @Autowired
    WebApplicationContext context;

    @Before
    public void init() {
        dao = (ProductDAO) context.getBean("productHibernateDao");
        ethalonProduct = (Product) context.getBean("product");
    }

    @Test
    public void aSavingWasSuccessful() {
        dao.save(ethalonProduct);
        Product product = dao.get(1);
        Assert.assertEquals(product.getPrice(), ethalonProduct.getPrice());
        Assert.assertEquals(product.getName(), ethalonProduct.getName());
    }

    @Test
    public void bGettingAllWasSuccesful() {
        Product product = dao.getAll().get(0);

        Assert.assertEquals(product.getPrice(), ethalonProduct.getPrice());
        Assert.assertEquals(product.getName(), ethalonProduct.getName());
    }

    @Test
    public void cDeletingWasSuccesful() {
        dao.delete(1);
        Assert.assertNull(dao.get(1));
    }
}