package com.example.md5_ss6_baith_1_ungdungquanlikhachhang.service;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
}
