package com.example.md5_baith_2_jpaprocedure.service;

import com.example.md5_baith_2_jpaprocedure.model.Customer;
import com.example.md5_baith_2_jpaprocedure.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return customerRepository.insertWithStoredProcedure(customer);
    }
}
