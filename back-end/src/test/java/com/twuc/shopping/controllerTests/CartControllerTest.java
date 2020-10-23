package com.twuc.shopping.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.Cart;
import com.twuc.shopping.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldAddCartSuccess() throws Exception {
        List<Product> products=new ArrayList<>();
        products.add(new Product(1, "./cola.png", "cola", 3, "瓶",1));
        Cart cart = new Cart(products);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(cart);

        mockMvc.perform(post("/cart")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
