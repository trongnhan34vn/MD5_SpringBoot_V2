package com.example.md5_ss8_baith_1_validatingforminput.service;

import com.example.md5_ss8_baith_1_validatingforminput.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    void save(Product product);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Page<Product> findByNameProduct(@Param("name") String name, Pageable pageable);
}

