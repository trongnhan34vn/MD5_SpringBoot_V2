package com.example.md5_ss7_baith_1_quanlikhachhang.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}

