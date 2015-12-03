package com.company.spring_application.dao;

import com.company.spring_application.database_helpers.AbstractJdbcTemplateHolder;
import com.company.spring_application.database_helpers.JdbcDaoInterface;
import com.company.spring_application.domain.Order;
import com.company.spring_application.domain.Product;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDAO extends AbstractJdbcTemplateHolder implements JdbcDaoInterface<Order> {
    private ClientDAO clientDAO;
    private ProductDAO productDAO;

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    @Override
    public List<Order> getAll() {
        String sql = "SELECT * FROM spring_application.orders";

        return getJdbcTemplate().query(sql.toString(), (rs, rowNum) -> {
            System.out.println(rs.getInt(1));
            Order order = new Order(clientDAO.get(rs.getInt(3)), rs.getString(2), productDAO.getAllInOrder(rs.getInt(1)));
            order.setId(rs.getInt(1));
            return order;
        });
    }

    @Override
    public Order get(int id) {
        String sql = "SELECT * FROM spring_application.orders WHERE id = :id";
        SqlParameterSource namedParameter = new MapSqlParameterSource("id", id);
        return (Order) getJdbcTemplate().queryForObject(
                sql.toString(),
                namedParameter,
                (rs, rowNum) -> {
                    Order order = new Order(clientDAO.get(rs.getInt(3)), rs.getString(2), productDAO.getAllInOrder(rs.getInt(1)));
                    order.setId(rs.getInt(1));
                    return order;
                }
        );
    }

    @Override
    public void save(Order order) {
        clientDAO.save(order.getClient());
        int clientId = clientDAO.getLastId();

        for (Product p : order.getProducts()) {
            productDAO.save(p);
        }

        String sql = "INSERT INTO spring_application.orders (task,client_id) VALUES(:task,:client_id)";
        Map namedParameters = new HashMap();
        namedParameters.put("task", order.getTaskDescription());
        namedParameters.put("client_id", clientId);

        getJdbcTemplate().update(sql, namedParameters);
    }

    @Override
    public int getLastId() {
        String sql = "SELECT id FROM spring_application.orders ORDER BY id DESC LIMIT 1";
        int last = -1;
        try {
            last = getJdbcTemplate().query(sql, (rs, rowNum) -> rs.getInt(1)).get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return last;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM spring_application.orders WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        getJdbcTemplate().update(sql, namedParameters);
    }

    public void delete(Order order) {
        String sql = "DELETE FROM spring_application.orders WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", order.getId());
        getJdbcTemplate().update(sql, namedParameters);
    }
}
