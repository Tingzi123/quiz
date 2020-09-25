package com.twuc.shopping.service;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<Order> getAllOrders(){
        return orderRepo.getAllOrders();
    }

    public void addOrder(Order order){
        orderRepo.addOrder(order);
    }

}
