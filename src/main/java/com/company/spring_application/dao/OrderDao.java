package com.company.spring_application.dao;

import com.company.spring_application.domain.Order;
import com.company.spring_application.domain.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderDAO {
    private JdbcTemplate jdbcTemplate;
    private ClientDAO clientDAO;
    private ProductDAO productDAO;
    private final String tableName = "spring_application.orders";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


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


    public List<Order> getAll(){
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName);
        return jdbcTemplate.query(sql.toString(), (rs, rowNum) ->
            new Order(rs.getInt(3),clientDAO.getById(rs.getInt(4)),rs.getString(2),productDAO.getById(rs.getInt(5)))
        );
    }

    public List<Order> getByOrderNumber(int order_number){
        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(tableName).append(" where order_number=").append(order_number);
        return jdbcTemplate.query(sql.toString(), (rs, rowNum) ->
                new Order(rs.getInt(3),clientDAO.getById(rs.getInt(4)),rs.getString(2),productDAO.getById(rs.getInt(5)))
        );
    }

    public void saveOrder(Order order){
        //TODO: add logic to check whether client with specified name and surname exists in DB or not
        //saving client to clients table
        clientDAO.save(order.getClient());
        int clientId = clientDAO.getIdByClient(order.getClient());

        //creating several orders with same order_number but different id in DB and product_id
        for (Product p: order.getProducts()){
            StringBuilder sql = new StringBuilder("INSERT INTO ");
            sql.append(tableName).append(" (task,order_number,client_id,product_id) VALUES('")
                    .append(order.getTaskDescription()).append("','")
                    .append(order.getId()).append("','")
                    .append(clientId).append("','")
                    .append(p.getId()).append("')");
            jdbcTemplate.update(sql.toString());
        }
    }


    public int deleteOrder(Order order){
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(tableName)
                .append(" WHERE order_number='").append(order.getId())
                .append("'");
        return jdbcTemplate.update(sql.toString());
    }

    public int deleteOrder(int order_number){
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(tableName)
                .append(" WHERE order_number='").append(order_number)
                .append("'");
        return jdbcTemplate.update(sql.toString());
    }
}
