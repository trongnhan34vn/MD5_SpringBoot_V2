package com.example.md5_ss7_baith_1_quanlikhachhang.repository;

import com.example.md5_ss7_baith_1_quanlikhachhang.model.Customer;
import com.example.md5_ss7_baith_1_quanlikhachhang.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince (Province province);
}
