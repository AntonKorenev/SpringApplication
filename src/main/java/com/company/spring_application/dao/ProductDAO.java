package com.company.spring_application.dao;

import com.company.spring_application.database_helpers.AbstractJdbcTemplateHolder;
import com.company.spring_application.database_helpers.JdbcDaoInterface;
import com.company.spring_application.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class ProductDAO extends AbstractJdbcTemplateHolder implements JdbcDaoInterface<Product> {
    private final String tableName = "spring_application.products";

    @Override
    public List<Product> getAll() {
        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(tableName);

        return getJdbcTemplate().query(sql.toString(),
                (rs, rowNum) -> new Product(rs.getInt(1), rs.getDouble(2), rs.getString(3))
        );
    }

    @Override
    public Product get(int id) {
        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(tableName).append(" where id = ?");
        Product product = (Product) getJdbcTemplate().queryForObject(
                sql.toString(),
                new Object[]{new Integer(id)},
                (RowMapper) (rs, rowNum) -> new Product(rs.getInt(1), rs.getDouble(2), rs.getString(3))
        );
        return product;
    }

    @Override
    public void save(Product product) {
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(tableName).append(" (id,price,name) VALUES('")
                .append(product.getId()).append("','")
                .append(product.getPrice()).append("','")
                .append(product.getName()).append("')");
        getJdbcTemplate().update(sql.toString());
    }

    @Override
    public void delete(int id) {
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(tableName)
                .append(" WHERE id='").append(id)
                .append("'");
        getJdbcTemplate().update(sql.toString());
    }

    @Override
    public int getLastId() {
        StringBuilder sql = new StringBuilder("SELECT id FROM ");
        sql.append(tableName).append(" ORDER BY id DESC LIMIT 1;");
        int last = -1;
        try {
            last = getJdbcTemplate().queryForObject(sql.toString(), (rs, rowNum) -> {
                return rs.getInt(1);
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return last;
    }

    public List<Product> getAllInOrder(int orderId) {
        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(tableName).append(" where order_id='").append(orderId).append("';");
        return getJdbcTemplate().query(sql.toString(),
                (rs, rowNum) -> new Product(rs.getInt(1), rs.getDouble(2), rs.getString(3))
        );
    }

    public int update(Product product) {
        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(tableName)
                .append(" SET id='").append(product.getId())
                .append("',price='").append(product.getPrice())
                .append("',name='").append(product.getName())
                .append("' WHERE id='").append(product.getId()).append("' ");
        return getJdbcTemplate().update(sql.toString());
    }
}
