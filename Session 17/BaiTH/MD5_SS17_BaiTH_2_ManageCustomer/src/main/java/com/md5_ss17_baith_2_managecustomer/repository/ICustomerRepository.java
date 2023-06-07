package com.md5_ss17_baith_2_managecustomer.repository;

import com.md5_ss17_baith_2_managecustomer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
