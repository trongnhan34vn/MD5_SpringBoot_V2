package com.example.md5_baith_2_jpaprocedure.repository;

import com.example.md5_baith_2_jpaprocedure.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
