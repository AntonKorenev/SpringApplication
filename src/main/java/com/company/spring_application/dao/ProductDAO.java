package com.company.spring_application.dao;

import com.company.spring_application.database_helpers.AbstractJdbcTemplateHolder;
import com.company.spring_application.database_helpers.JdbcDaoInterface;
import com.company.spring_application.domain.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAO extends AbstractJdbcTemplateHolder implements JdbcDaoInterface<Product> {

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM spring_application.products";
        return getJdbcTemplate().query(sql,
                (rs, rowNum) -> new Product(rs.getInt(1), rs.getDouble(2), rs.getString(3))
        );
    }

    @Override
    public Product get(int id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM spring_application.products WHERE id = :id");
        Product product = (Product) getJdbcTemplate().queryForObject(
                sql.toString(),
                new MapSqlParameterSource("id", id),
                (RowMapper) (rs, rowNum) -> new Product(rs.getInt(1), rs.getDouble(2), rs.getString(3))
        );
        return product;
    }

    @Override
    public void save(Product product) {
        String sql = "INSERT INTO spring_application.products (id,price,name) VALUES(:id,:price,:name)";
        Map namedParameters = new HashMap();
        namedParameters.put("id", product.getId());
        namedParameters.put("price", product.getPrice());
        namedParameters.put("name", product.getName());
        getJdbcTemplate().update(sql, namedParameters);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM spring_application.products WHERE id = :id";
        getJdbcTemplate().update(sql, new MapSqlParameterSource("id", id));
    }

    @Override
    public int getLastId() {
        String sql = "SELECT id FROM spring_application.products ORDER BY id DESC LIMIT 1";
        int last = -1;
        try {
            last = getJdbcTemplate().query(sql, (rs, rowNum) -> rs.getInt(1)).get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return last;
    }

    public List<Product> getAllInOrder(int orderId) {
        String sql = "SELECT * FROM spring_application.products WHERE order_id = :order_id";
        return getJdbcTemplate().query(
                sql,
                new MapSqlParameterSource("order_id", orderId),
                (rs, rowNum) -> new Product(rs.getInt(1), rs.getDouble(2), rs.getString(3))
        );
    }

    public int update(Product product) {
        String sql = "UPDATE spring_application.products SET id = :id, price = :price, name = :name WHERE id = :id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", product.getId());
        namedParameters.put("price", product.getPrice());
        namedParameters.put("name", product.getName());
        return getJdbcTemplate().update(sql, namedParameters);
    }
}
