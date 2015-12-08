package com.company.spring_application.dao;

import com.company.spring_application.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath:web.xml")
@ContextConfiguration("classpath:spring_config.xml")
public class ProductDAOTest implements JdbcDaoTestInterface {
    Product referenceProduct;
    ProductDAO dao;

    @Autowired
    WebApplicationContext context;

    @Before
    public void init() {
        dao = (ProductDAO) context.getBean("productDao");
        referenceProduct = new Product();
    }

    @Override
    @Test
    public void aSavingWasSuccesful() throws Exception {
        dao.save(new Product());
        Product product = dao.get(dao.getLastId());
        assertTrue(product.getPrice() == referenceProduct.getPrice());
        assertTrue(product.getName().equals(referenceProduct.getName()));
    }

    @Override
    @Test(expected = EmptyResultDataAccessException.class)
    public void bDeletingWasSuccessful() throws Exception {
        dao.delete(referenceProduct.getId());
        System.out.println(dao.get(referenceProduct.getId()));
    }

    @Override
    @Test
    public void cUpdatingWasSuccessful() throws Exception {
        int last = dao.getLastId();
        if (last <= 0) {
            dao.save(referenceProduct);
            last = dao.getLastId();
        }
        dao.update(new Product(last, 0, "Upd"));
        Product client = dao.get(last);
        assertTrue(client.getName().equals("Upd"));
    }

    @Override
    @Test
    public void dGetAllReturnsProperValues() throws Exception {
        int beforeSize = dao.getAll().size();
        dao.save(referenceProduct);
        dao.save(referenceProduct);
        assertTrue((dao.getAll().size() - beforeSize) == 2);
    }

    @Override
    @Test
    public void eGetLastIdWorksCorrectly() throws Exception {
        int before = dao.getLastId();
        dao.save(referenceProduct);
        int after = dao.getLastId();
        assertTrue((after - before) == 1);
    }
}