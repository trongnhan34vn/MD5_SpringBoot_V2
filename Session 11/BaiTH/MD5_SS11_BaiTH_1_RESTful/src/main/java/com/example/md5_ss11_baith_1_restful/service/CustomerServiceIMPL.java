package com.example.md5_ss11_baith_1_restful.service;

import com.example.md5_ss11_baith_1_restful.model.Customer;
import com.example.md5_ss11_baith_1_restful.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerServiceIMPL implements ICustomerService{
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
            customerRepository.deleteById(id);
    }
}
