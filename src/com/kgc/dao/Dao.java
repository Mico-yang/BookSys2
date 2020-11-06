package com.kgc.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
    void insert(T t);

    void update(T t);

    void delete(Serializable id);

    List<T> findAll();

    T findById(Serializable id);
}
