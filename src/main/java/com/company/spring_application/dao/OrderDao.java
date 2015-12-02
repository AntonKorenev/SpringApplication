package com.company.spring_application.dao;

import com.company.spring_application.databasehelpers.AbstractJdbcTemplateHolder;
import com.company.spring_application.domain.Order;
import com.company.spring_application.domain.Product;

import java.util.List;

public class OrderDAO extends AbstractJdbcTemplateHolder {
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

    public List<Order> getAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName);
        return getJdbcTemplate().query(sql.toString(), (rs, rowNum) -> {
            System.out.println(rs.getInt(1));
            Order order = new Order(clientDAO.getById(rs.getInt(3)), rs.getString(2), productDAO.getWhereOrderId(rs.getInt(1)));
            order.setId(rs.getInt(1));
            return order;
        });
    }

    public List<Order> getByOrderNumber(int order_number) {
        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(tableName).append(" where order_number=").append(order_number);
        return getJdbcTemplate().query(sql.toString(), (rs, rowNum) -> {
                    Order order = new Order(clientDAO.getById(rs.getInt(3)), rs.getString(2), productDAO.getById(rs.getInt(1)));
                    order.setId(rs.getInt(1));
                    return order;
                }
        );
    }

    public void saveOrder(Order order) {
        clientDAO.save(order.getClient());
        int clientId = clientDAO.getIdByClient(order.getClient());

        for (Product p : order.getProducts()) {
            productDAO.save(p);
        }

        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(tableName).append(" (task,client_id) VALUES('")
                .append(order.getTaskDescription()).append("','")
                .append(clientId).append("')");
        getJdbcTemplate().update(sql.toString());
    }

    public int deleteOrder(Order order) {
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(tableName)
                .append(" WHERE id='").append(order.getId())
                .append("'");
        return getJdbcTemplate().update(sql.toString());
    }

    public int deleteOrder(int id) {
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(tableName)
                .append(" WHERE id='").append(id)
                .append("'");
        return getJdbcTemplate().update(sql.toString());
    }
}
