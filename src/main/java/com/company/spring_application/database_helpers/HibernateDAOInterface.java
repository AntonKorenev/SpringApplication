package com.company.spring_application.database_helpers;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HibernateDAOInterface<T extends DOInterface> {
    @Transactional
    public void delete(int id);

    @Transactional
    public void save(T saving);

    @Transactional
    public T get(int id);

    @Transactional
    public List<T> getAll();

    @Transactional
    public T getLast();
}
