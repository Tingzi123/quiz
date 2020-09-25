package com.twuc.shopping.service;

import com.twuc.shopping.repository.OrderRepo;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
}
