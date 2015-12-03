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
    Product referenceProduct;

    @Autowired
    WebApplicationContext context;

    @Before
    public void init() {
        dao = (ProductDAO) context.getBean("productHibernateDao");
        referenceProduct = new Product();
    }


    @Test
    public void aSavingWasSuccessful() {
        dao.save(referenceProduct);
        Product product = dao.getLast();
        Assert.assertTrue(product.getPrice() == referenceProduct.getPrice());
        Assert.assertEquals(product.getName(),referenceProduct.getName());
    }

    @Test
    public void bGettingAllWasSuccesful() {
        int before = dao.getAll().size();
        dao.save(referenceProduct);
        dao.save(referenceProduct);
        int after = dao.getAll().size();
        Assert.assertTrue((after-before)==2);
    }

    @Test
    public void cDeletingWasSuccesful() {
        dao.save(referenceProduct);
        int last = dao.getLast().getId();
        dao.delete(last);
        Assert.assertNull(dao.get(last));
    }
}