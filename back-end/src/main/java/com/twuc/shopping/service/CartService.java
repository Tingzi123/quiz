package com.twuc.shopping.service;

import com.twuc.shopping.dto.Cart;
import com.twuc.shopping.dto.Order;
import com.twuc.shopping.entity.CartEntity;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.CartRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {
    private CartRepo cartRepo;

    public CartService(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    public void addCart(Cart cart) {
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


        cartRepo.save(CartEntity.builder()
                .products(productEntities)
                .build());
    }
}
