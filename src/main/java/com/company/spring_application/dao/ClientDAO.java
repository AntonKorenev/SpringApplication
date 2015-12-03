package com.company.spring_application.dao;

import com.company.spring_application.database_helpers.AbstractJdbcTemplateHolder;
import com.company.spring_application.database_helpers.JdbcDaoInterface;
import com.company.spring_application.domain.Client;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class ClientDAO extends AbstractJdbcTemplateHolder implements JdbcDaoInterface<Client> {
    private final String tableName = "spring_application.clients";

    @Override
    public List<Client> getAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName);
        return getJdbcTemplate().query(sql.toString(), (rs, rowNum) -> new Client(rs.getString(2), rs.getString(3)));
    }

    @Override
    public Client get(int id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName).append(" WHERE id = ?");
        return (Client) getJdbcTemplate().queryForObject(
                sql.toString(),
                new Object[]{id},
                (RowMapper) (rs, rowNum) -> new Client(rs.getString(2), rs.getString(3))
        );
    }

    @Override
    public void save(Client client) {
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(tableName).append(" (first_name,last_name) VALUES('")
                .append(client.getFirstName()).append("','")
                .append(client.getLastName()).append("')");
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

    public void delete(Client client) {
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(tableName)
                .append(" WHERE id='").append(client.getId())
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

    public int update(Client client, int id) {
        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(tableName)
                .append(" SET first_name='").append(client.getFirstName())
                .append("',last_name='").append(client.getLastName())
                .append("' WHERE id='").append(id).append("' ");
        return getJdbcTemplate().update(sql.toString());
    }


    public Client get(String name) {
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName).append(" WHERE first_name = ?");
        return (Client) getJdbcTemplate().queryForObject(
                sql.toString(),
                new Object[]{name},
                (RowMapper) (rs, rowNum) -> new Client(rs.getString(2), rs.getString(3))
        );
    }

    public List<Integer> getId(Client client) {
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName).append(" WHERE first_name = ? AND last_name  = ?");
        return getJdbcTemplate().query(
                sql.toString(),
                new Object[]{client.getFirstName(), client.getLastName()},
                (RowMapper) (rs, rowNum) -> rs.getInt(1)
        );
    }
}
