package com.example.md5_ss10_baitap_giohang.controller;

import com.example.md5_ss10_baitap_giohang.model.Cart;
import com.example.md5_ss10_baitap_giohang.model.Order;
import com.example.md5_ss10_baitap_giohang.model.OrderItem;
import com.example.md5_ss10_baitap_giohang.model.Product;
import com.example.md5_ss10_baitap_giohang.service.IOrderItemService;
import com.example.md5_ss10_baitap_giohang.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderItemService orderItemService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/payment")
    public String createOrder(@SessionAttribute Cart cart) {
        Order newOrder = orderService.saveAndReturn(new Order()).get();
        System.out.println("Id -----> " + newOrder.getOrderId());
        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;
        for (Map.Entry<Product,Integer> entry:cart.getProducts().entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(entry.getKey());
            orderItem.setPrice(entry.getKey().getPrice());
            orderItem.setOrder(newOrder);
            orderItem.setQuantity(entry.getValue());
            orderItemService.save(orderItem);
            orderItems.add(orderItem);
            total = total + orderItem.getQuantity() * orderItem.getPrice();
        }
        newOrder.setOrderItems(orderItems);
        newOrder.setTotal(total);
        orderService.save(newOrder);
        return "/cart";
    }
}
