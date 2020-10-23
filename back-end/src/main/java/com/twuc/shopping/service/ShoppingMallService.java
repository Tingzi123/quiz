package com.twuc.shopping.service;

import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ShoppingMallRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingMallService {
    private ShoppingMallRepo shoppingMallRepo;

    public ShoppingMallService(ShoppingMallRepo shoppingMallRepo) {
        this.shoppingMallRepo = shoppingMallRepo;
    }

    public void addProduct(Product product){
        ProductEntity productEntity=ProductEntity.builder()
                .name(product.getName())
                .imgSrc(product.getImgSrc())
                .price(product.getPrice())
                .unit(product.getUnit())
                .build();

        shoppingMallRepo.save(productEntity);
    }

    public List<Product> getAllProducts(){
        return shoppingMallRepo.findAll().stream().map(productEntity -> {
            Product product= Product.builder()
                    .name(productEntity.getName())
                    .imgSrc(productEntity.getImgSrc())
                    .price(productEntity.getPrice())
                    .unit(productEntity.getUnit())
                    .build();
            return product;
        }).collect(Collectors.toList());
    }
}
