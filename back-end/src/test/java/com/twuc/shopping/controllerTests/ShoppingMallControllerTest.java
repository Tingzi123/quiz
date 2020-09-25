package com.twuc.shopping.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShoppingMallControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldAddProductSuccess() throws Exception {
        Product product=new Product(1,"./cola.png","cola",3);
        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(product);

        mockMvc.perform(post("/product")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("cola")));
    }

    @Test
    void shouldGetAllProducts() throws Exception {
        mockMvc.perform(get("/user/register")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("cola")));
    }
}
