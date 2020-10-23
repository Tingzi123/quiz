package com.twuc.shopping.service;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<Order> getAllOrders(){
        return orderRepo.findAll().stream().map(orderEntity -> {
            Product product=Product.builder()
                    .imgSrc(orderEntity.getProduct().getImgSrc())
                    .name(orderEntity.getProduct().getName())
                    .price(orderEntity.getProduct().getPrice())
                    .unit(orderEntity.getProduct().getUnit())
                    .build();

            Order order=Order.builder()
                    .num(orderEntity.getNum())
                    .product(product)
                    .build();
            return order;
        }).collect(Collectors.toList());
    }

    public void addOrder(Order order){
        ProductEntity productEntity=ProductEntity.builder()
                .imgSrc(order.getProduct().getImgSrc())
                .name(order.getProduct().getName())
                .price(order.getProduct().getPrice())
                .unit(order.getProduct().getUnit())
                .build();

        orderRepo.save(OrderEntity.builder()
                .num(order.getNum())
                .product(productEntity)
                .build());
    }
}
