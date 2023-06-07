package com.example.md5_ss10_baith_3_session_cart.service;

import com.example.md5_ss10_baith_3_session_cart.model.Product;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
