package com.company.spring_application.databasehelpers;

import com.company.spring_application.databasehelpers.DOInterface;
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
}
