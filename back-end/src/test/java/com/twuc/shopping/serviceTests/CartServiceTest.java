package com.twuc.shopping.serviceTests;

import com.twuc.shopping.dto.Cart;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.CartEntity;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.CartRepo;
import com.twuc.shopping.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class CartServiceTest {
    @Mock
    CartRepo cartRepo;

    CartService cartService;

    @BeforeEach
    void setUp() {
        initMocks(this);
        cartService = new CartService(cartRepo);
    }

    @Test
    void shouldAddOrderSuccess() {
        List<Product> products=new ArrayList<>();
        products.add(new Product(1, "./cola.png", "cola", 3, "瓶",1));
        Cart cart = new Cart(products);

        List<ProductEntity> productEntities=cart.getProducts().stream().map(product -> {
            ProductEntity productEntity = ProductEntity.builder()
                    .imgSrc(product.getImgSrc())
                    .name(product.getName())
                    .price(product.getPrice())
                    .unit(product.getUnit())
                    .num(product.getNum())
                    .build();
            return productEntity;
        }).collect(Collectors.toList());

        CartEntity cartEntity=CartEntity.builder()
                .products(productEntities)
                .build();

        cartService.addCart(cart);
        verify(cartRepo).save(cartEntity);
    }
}
