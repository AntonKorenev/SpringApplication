package com.company.spring_application.databasehelpers;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractJdbcTemplateHolder {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}