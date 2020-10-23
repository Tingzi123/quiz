package com.twuc.shopping.controller;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/order")
    public ResponseEntity addProduct(@RequestBody Order order){
        orderService.addOrder(order);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @PostMapping(value = "/{orderId}/order")
    public ResponseEntity deletedOrders(@PathVariable("orderId") String orderId){
        int id=Integer.parseInt(orderId);
        orderService.deletedOrders(id);
        return ResponseEntity.ok().build();
    }
}
