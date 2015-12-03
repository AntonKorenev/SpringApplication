package com.company.spring_application.database_helpers;

import java.util.List;

public interface JdbcDaoInterface<T extends DOInterface> {
    public void save(T saving);

    public void delete(int id);

    public T get(int id);

    public List<T> getAll();

    public int getLastId();
}
