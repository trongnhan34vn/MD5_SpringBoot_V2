package com.example.md5_ss10_baitap_giohang.service;

import com.example.md5_ss10_baitap_giohang.model.Order;

import java.util.Optional;

public interface IOrderService extends IGenericService<Order> {
    Optional<Order> saveAndReturn(Order order);
}
