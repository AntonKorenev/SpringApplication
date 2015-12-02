package com.company.spring_application.dao;

import com.company.spring_application.databasehelpers.AbstractJdbcTemplateHolder;
import com.company.spring_application.domain.Client;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class ClientDAO extends AbstractJdbcTemplateHolder {
    private final String tableName = "spring_application.clients";

    public List<Client> getAll(){
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName);
        return getJdbcTemplate().query(sql.toString(), (rs, rowNum) -> new Client(rs.getString(2),rs.getString(3)));
    }

    public Client getById(int id){
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName).append(" WHERE id = ?");
        return (Client)getJdbcTemplate().queryForObject(
                sql.toString(),
                new Object[]{id},
                (RowMapper) (rs, rowNum) -> new Client(rs.getString(2),rs.getString(3))
        );
    }

    public Client getByName(String name){
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName).append(" WHERE first_name = ?");
        return (Client)getJdbcTemplate().queryForObject(
                sql.toString(),
                new Object[]{name},
                (RowMapper) (rs, rowNum) -> new Client(rs.getString(2),rs.getString(3))
        );
    }

    public int getIdByClient(Client client){
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName).append(" WHERE first_name = ? AND last_name  = ?");
        return (int) (Integer)getJdbcTemplate().queryForObject(
                sql.toString(),
                new Object[]{client.getFirstName(), client.getLastName()},
                (RowMapper) (rs, rowNum) -> rs.getInt(1)
        );
    }

    public int save(Client client){
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(tableName).append(" (first_name,last_name) VALUES('")
                .append(client.getFirstName()).append("','")
                .append(client.getLastName()).append("')");
        return getJdbcTemplate().update(sql.toString());
    }

    public int updateClient(Client client, int id){
        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(tableName)
                .append(" SET first_name='").append(client.getFirstName())
                .append("',last_name='").append(client.getLastName())
                .append("' WHERE id='").append(id).append("' ");
        return getJdbcTemplate().update(sql.toString());
    }

    public int deleteClient(Client client){
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(tableName)
                .append(" WHERE first_name='").append(client.getFirstName())
                .append("' AND last_name='").append(client.getLastName())
                .append("'");
        return getJdbcTemplate().update(sql.toString());
    }
}
