package com.md5_ss17_baith_2_managecustomer.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

}

