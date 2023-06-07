package com.example.md5_ss11_baith_1_restful.repository;

import com.example.md5_ss11_baith_1_restful.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
