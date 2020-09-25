package com.twuc.shopping.controller;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.service.OrderService;
import com.twuc.shopping.service.ShoppingMallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
}
