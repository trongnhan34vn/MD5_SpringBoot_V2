package com.md5_ss17_baitap_1_productmanager.service;

import com.md5_ss17_baitap_1_productmanager.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save (Product product);
    void remove(Long id);
}
