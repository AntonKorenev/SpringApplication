package com.company.spring_application.dao;

import com.company.spring_application.database_helpers.AbstractJdbcTemplateHolder;
import com.company.spring_application.database_helpers.JdbcDaoInterface;
import com.company.spring_application.domain.Client;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDAO extends AbstractJdbcTemplateHolder implements JdbcDaoInterface<Client> {
    @Override
    public List<Client> getAll() {
        String sql = "SELECT * FROM spring_application.clients";
        return getJdbcTemplate().query(sql, (rs, rowNum) -> new Client(rs.getString(2), rs.getString(3)));
    }

    @Override
    public Client get(int id) {
        String sql = "SELECT * FROM spring_application.clients WHERE id = :id ";
        return getJdbcTemplate().queryForObject(
                sql,
                new MapSqlParameterSource("id", id),
                (rs, rowNum) -> new Client(rs.getString(2), rs.getString(3))
        );
    }

    @Override
    public void save(Client client) {
        String sql = "INSERT INTO spring_application.clients (first_name,last_name) VALUES (:first_name, :last_name)";
        Map namedParameter = new HashMap<>();
        namedParameter.put("first_name", client.getFirstName());
        namedParameter.put("last_name", client.getLastName());
        getJdbcTemplate().update(sql, namedParameter);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM spring_application.clients WHERE id = :id";
        getJdbcTemplate().update(sql, new MapSqlParameterSource("id", id));
    }

    @Override
    public int getLastId() {
        String sql = "SELECT id FROM spring_application.clients ORDER BY id DESC LIMIT 1";
        int last = -1;
        try {
            last = getJdbcTemplate().query(sql, (rs, rowNum) -> rs.getInt(1)).get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return last;
    }

    public int update(Client client, int id) {
        String sql = "UPDATE spring_application.clients SET first_name = :first_name, last_name = :last_name WHERE id = :id";
        Map namedParameters = new HashMap<>();
        namedParameters.put("first_name", client.getFirstName());
        namedParameters.put("last_name", client.getLastName());
        namedParameters.put("id", id);
        return getJdbcTemplate().update(sql, namedParameters);
    }


    public Client get(String name) {
        String sql = "SELECT * FROM spring_application.clients WHERE first name = :first_name";
        return getJdbcTemplate().queryForObject(
                sql,
                new MapSqlParameterSource("first_name", name),
                (rs, rowNum) -> new Client(rs.getString(2), rs.getString(3))
        );
    }

    public List<Integer> getId(Client client) {
        String sql = "SELECT * FROM spring_application.clients WHERE first_name = :first_name AND last_name = :last_name";
        Map namedParameters = new HashMap<>();
        namedParameters.put("first_name", client.getFirstName());
        namedParameters.put("last_name", client.getLastName());
        return getJdbcTemplate().query(
                sql.toString(),
                namedParameters,
                (rs, rowNum) -> rs.getInt(1)
        );
    }
}
