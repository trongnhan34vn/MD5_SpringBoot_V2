package com.example.md5_ss10_baitap_giohang.repository;

import com.example.md5_ss10_baitap_giohang.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
