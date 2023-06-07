package com.example.md5_ss7_baitap_1_blog.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}

