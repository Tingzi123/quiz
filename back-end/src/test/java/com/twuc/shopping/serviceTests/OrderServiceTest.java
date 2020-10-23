package com.twuc.shopping.serviceTests;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.OrderRepo;
import com.twuc.shopping.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class OrderServiceTest {
    @Mock
    OrderRepo orderRepo;

    OrderService orderService;

    @BeforeEach
    void setUp() {
        initMocks(this);
        orderService = new OrderService(orderRepo);
    }

    @Test
    void shouldGetAllOrdersSuccess() {
        orderService.getAllOrders();
        verify(orderRepo).findAll();
        verify(orderService).getAllOrders();

        assertEquals("cola",orderRepo.findAll().get(0).getProducts().get(0).getName());
    }

    @Test
    void shouldAddOrderSuccess() {
        List<Product> products=new ArrayList<>();
        products.add(new Product(1, "./cola.png", "cola", 3, "瓶",1));
        Order order = new Order(products);

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

        OrderEntity orderEntity=OrderEntity.builder()
                .products(productEntities)
                .build();

        orderService.addOrder(order);
        verify(orderRepo).save(orderEntity);
    }

    @Test
    void shouldDeleteOrderSuccess() {
        List<Product> products=new ArrayList<>();
        products.add(new Product(1, "./cola.png", "cola", 3, "瓶",1));
        Order order = new Order(products);

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

        OrderEntity orderEntity=OrderEntity.builder()
                .products(productEntities)
                .build();

        orderService.deletedOrders(orderEntity.getId());
        verify(orderRepo).deleteById(orderEntity.getId());
    }
}
