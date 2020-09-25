package com.twuc.shopping.serviceTests;

import com.twuc.shopping.repository.OrderRepo;
import com.twuc.shopping.repository.ShoppingMallRepo;
import com.twuc.shopping.service.OrderService;
import com.twuc.shopping.service.ShoppingMallService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

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
}
