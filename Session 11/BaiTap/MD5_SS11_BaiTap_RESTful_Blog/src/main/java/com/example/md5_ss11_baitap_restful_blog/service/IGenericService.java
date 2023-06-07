package com.example.md5_ss11_baitap_restful_blog.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);

}
