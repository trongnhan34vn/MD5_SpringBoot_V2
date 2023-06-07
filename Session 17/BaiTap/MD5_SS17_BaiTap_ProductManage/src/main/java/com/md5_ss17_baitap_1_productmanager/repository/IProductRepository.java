package com.md5_ss17_baitap_1_productmanager.repository;

import com.md5_ss17_baitap_1_productmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

}
