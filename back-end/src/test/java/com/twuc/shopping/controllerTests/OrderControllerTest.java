package com.twuc.shopping.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.Order;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.OrderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    OrderRepo orderRepo;

    @Test
    void shouldGetAllOrders() throws Exception {
        mockMvc.perform(get("/orders")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].product.getName()", is("cola")));
    }

    @Test
    void shouldAddOrderSuccess() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "./cola.png", "cola", 3, "瓶", 1));
        Order order = new Order(products);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(order);

        mockMvc.perform(post("/order")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteOrderSuccess() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "./cola.png", "cola", 3, "瓶", 1));
        Order order = new Order(products);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(order);

        mockMvc.perform(post("/order")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        OrderEntity orderEntity = orderRepo.findAll().get(0);

        mockMvc.perform(post("/" + orderEntity.getId().toString() + "/order")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
