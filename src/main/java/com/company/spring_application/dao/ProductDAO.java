package com.company.spring_application.dao;

import com.company.spring_application.domain.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class ProductDAO {
    private JdbcTemplate jdbcTemplate;
    private final String tableName = "spring_application.products";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public List<Product> getAll(){
        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(tableName);

        return jdbcTemplate.query(sql.toString(),
                (rs, rowNum) -> new Product(rs.getInt(1),rs.getDouble(2),rs.getString(3))
        );
    }

    public Product getById(int id){
        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(tableName).append(" where id = ?");
        Product product = (Product)jdbcTemplate.queryForObject(
                sql.toString(),
                new Object[]{new Integer(id)},
                (RowMapper) (rs, rowNum) -> new Product(rs.getInt(1),rs.getDouble(2),rs.getString(3))
        );
        return product;
    }

    public int save(Product product){
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(tableName).append(" (id,price,name) VALUES('")
                .append(product.getId()).append("','")
                .append(product.getPrice()).append("','")
                .append(product.getName()).append("')");
        return jdbcTemplate.update(sql.toString());
    }

    public int updateClient(Product product){
        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(tableName)
                .append(" SET id='").append(product.getId())
                .append("',price='").append(product.getPrice())
                .append("',name='").append(product.getName())
                .append("' WHERE id='").append(product.getId()).append("' ");
        return jdbcTemplate.update(sql.toString());
    }

    public int deleteClient(Product product){
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(tableName)
                .append(" WHERE id='").append(product.getId())
                .append("'");
        return jdbcTemplate.update(sql.toString());
    }
}
