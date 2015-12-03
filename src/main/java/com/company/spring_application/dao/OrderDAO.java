package com.company.spring_application.dao;

import com.company.spring_application.database_helpers.AbstractJdbcTemplateHolder;
import com.company.spring_application.database_helpers.JdbcDaoInterface;
import com.company.spring_application.domain.Order;
import com.company.spring_application.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class OrderDAO extends AbstractJdbcTemplateHolder implements JdbcDaoInterface<Order> {
    private final String tableName = "spring_application.orders";
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
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName);
        return getJdbcTemplate().query(sql.toString(), (rs, rowNum) -> {
            System.out.println(rs.getInt(1));
            Order order = new Order(clientDAO.get(rs.getInt(3)), rs.getString(2), productDAO.getAllInOrder(rs.getInt(1)));
            order.setId(rs.getInt(1));
            return order;
        });
    }

    @Override
    public Order get(int id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName).append(" WHERE id = ?");
        return (Order) getJdbcTemplate().queryForObject(
                sql.toString(),
                new Object[]{id},
                (RowMapper) (rs, rowNum) -> {
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

        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(tableName).append(" (task,client_id) VALUES('")
                .append(order.getTaskDescription()).append("','")
                .append(clientId).append("')");
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

    @Override
    public void delete(int id) {
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(tableName)
                .append(" WHERE id='").append(id)
                .append("'");
        getJdbcTemplate().update(sql.toString());
    }

    public int delete(Order order) {
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(tableName)
                .append(" WHERE id='").append(order.getId())
                .append("'");
        return getJdbcTemplate().update(sql.toString());
    }
}
