package com.example.md5_ss10_baitap_giohang.service.IMPL;

import com.example.md5_ss10_baitap_giohang.model.Order;
import com.example.md5_ss10_baitap_giohang.repository.IOrderRepository;
import com.example.md5_ss10_baitap_giohang.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderServiceIMPL implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void remove(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> saveAndReturn(Order order) {
        return Optional.of(orderRepository.save(order));
    }
}
