package com.company.spring_application.database_helpers;


import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void initialize() {
        DataSource dataSource = getDataSource();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            BufferedReader br = new BufferedReader(new FileReader("create_db.sql"));
            try {
                StringBuilder sql = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sql.append(line);
                    sql.append("\n");
                    line = br.readLine();
                }

                statement.executeUpdate(sql.toString());
                statement.close();
                connection.close();
            } finally {
                br.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}