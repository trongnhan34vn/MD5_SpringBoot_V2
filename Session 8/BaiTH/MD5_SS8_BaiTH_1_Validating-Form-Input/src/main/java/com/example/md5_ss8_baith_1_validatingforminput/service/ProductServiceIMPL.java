package com.example.md5_ss8_baith_1_validatingforminput.service;

import com.example.md5_ss8_baith_1_validatingforminput.model.Product;
import com.example.md5_ss8_baith_1_validatingforminput.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceIMPL implements IProductService{
    @Autowired
    IProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Product> findByNameProduct(String name, Pageable pageable) {
        return null;
    }
}
