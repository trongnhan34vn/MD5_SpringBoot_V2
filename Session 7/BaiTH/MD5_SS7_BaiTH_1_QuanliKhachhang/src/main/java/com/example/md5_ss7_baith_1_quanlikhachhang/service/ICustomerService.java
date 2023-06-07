package com.example.md5_ss7_baith_1_quanlikhachhang.service;

import com.example.md5_ss7_baith_1_quanlikhachhang.model.Customer;
import com.example.md5_ss7_baith_1_quanlikhachhang.model.Province;

public interface ICustomerService extends IGenericService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
