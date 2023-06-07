package com.example.md5_ss10_baitap_giohang.service;

import java.util.Optional;

public interface IGenericService<E> {
    Iterable<E> findAll();
    Optional<E> findById(Long id);
    void save(E e);
    void remove(Long id);
}
