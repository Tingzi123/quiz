package com.twuc.shopping.serviceTests;

import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ShoppingMallRepo;
import com.twuc.shopping.service.ShoppingMallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

class ShoppingMallServiceTest {
    @Mock
    ShoppingMallRepo shoppingMallRepo;

    ShoppingMallService shoppingMallService;

    @BeforeEach
    void setUp() {
        initMocks(this);
        shoppingMallService = new ShoppingMallService(shoppingMallRepo);
    }

    @Test
    void shouldAddProductSuccess() {
        Product product=new Product(1,"./cola.png","cola",3,"瓶",1);

        ProductEntity productEntity=ProductEntity.builder()
                .name(product.getName())
                .imgSrc(product.getImgSrc())
                .price(product.getPrice())
                .unit(product.getUnit())
                .build();

        shoppingMallService.addProduct(product);
        verify(shoppingMallRepo).save(productEntity);

        assertEquals("cola",shoppingMallRepo.findAll().get(0).getName());
    }

    @Test
    void shouldGetAllProductsSuccess() {
        shoppingMallService.getAllProducts();
        verify(shoppingMallRepo).findAll();
        verify(shoppingMallService).getAllProducts();

        assertEquals("cola",shoppingMallRepo.findAll().get(0).getName());
    }
}
