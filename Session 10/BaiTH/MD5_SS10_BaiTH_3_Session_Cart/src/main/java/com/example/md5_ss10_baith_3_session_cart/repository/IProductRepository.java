package com.example.md5_ss10_baith_3_session_cart.repository;

import com.example.md5_ss10_baith_3_session_cart.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {

}
