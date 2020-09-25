package com.twuc.shopping.controller;

import com.twuc.shopping.dto.Product;
import com.twuc.shopping.service.ShoppingMallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingMallController {
    private ShoppingMallService shoppingMallService;

    public ShoppingMallController(ShoppingMallService shoppingMallService) {
        this.shoppingMallService = shoppingMallService;
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product){
        shoppingMallService.addProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return shoppingMallService.getAllProducts();
    }
}
