package com.example.md5_ss10_baitap_giohang.service.IMPL;

import com.example.md5_ss10_baitap_giohang.model.Product;
import com.example.md5_ss10_baitap_giohang.repository.IProductRepository;
import com.example.md5_ss10_baitap_giohang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceIMPL implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }
}
