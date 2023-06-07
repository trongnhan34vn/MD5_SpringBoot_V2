package com.example.md5_baith_2_jpaprocedure.service;

import com.example.md5_baith_2_jpaprocedure.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
