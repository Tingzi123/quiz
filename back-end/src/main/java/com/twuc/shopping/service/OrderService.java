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

    public List<Order> getAllOrders() {
        return orderRepo.findAll().stream().map(orderEntity -> {
            List<Product> products = orderEntity.getProducts().stream().map(productEntity -> {
                Product product = Product.builder()
                        .imgSrc(productEntity.getImgSrc())
                        .name(productEntity.getName())
                        .price(productEntity.getPrice())
                        .unit(productEntity.getUnit())
                        .num(productEntity.getNum())
                        .build();
                return product;
            }).collect(Collectors.toList());


            Order order = Order.builder()
                    .products(products)
                    .build();
            return order;
        }).collect(Collectors.toList());
    }

    public void addOrder(Order order) {
        List<ProductEntity> productEntities=order.getProducts().stream().map(product -> {
            ProductEntity productEntity = ProductEntity.builder()
                    .imgSrc(product.getImgSrc())
                    .name(product.getName())
                    .price(product.getPrice())
                    .unit(product.getUnit())
                    .num(product.getNum())
                    .build();
            return productEntity;
        }).collect(Collectors.toList());


        orderRepo.save(OrderEntity.builder()
                .products(productEntities)
                .build());
    }

    public void deletedOrders(int orderId) {
        orderRepo.deleteById(orderId);
    }
}
