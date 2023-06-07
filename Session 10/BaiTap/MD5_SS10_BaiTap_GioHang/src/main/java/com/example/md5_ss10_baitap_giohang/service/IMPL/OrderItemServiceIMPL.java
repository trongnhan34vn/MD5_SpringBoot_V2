package com.example.md5_ss10_baitap_giohang.service.IMPL;

import com.example.md5_ss10_baitap_giohang.model.OrderItem;
import com.example.md5_ss10_baitap_giohang.repository.IOrderItemRepository;
import com.example.md5_ss10_baitap_giohang.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemServiceIMPL implements IOrderItemService {
    @Autowired
    private IOrderItemRepository orderItemRepository;
    @Override
    public Iterable<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public void save(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    public void remove(Long id) {
        orderItemRepository.deleteById(id);
    }
}
