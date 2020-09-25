package com.twuc.shopping.serviceTests;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.repository.OrderRepo;
import com.twuc.shopping.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
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
        verify(orderRepo).getAllOrders();
        verify(orderService).getAllOrders();

        assertEquals("cola",orderRepo.getAllOrders().get(0).getProduct().getName());
    }

    @Test
    void shouldAddOrderSuccess() {
        Order order=new Order(1,new Product(1,"./cola.png","cola",3));

        verify(orderRepo).addOrder(order);
        verify(orderService).addOrder(order);
    }
}
