package com.twuc.shopping.service;

import com.twuc.shopping.dto.Product;
import com.twuc.shopping.repository.ShoppingMallRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingMallService {
    private ShoppingMallRepo shoppingMallRepo;

    public ShoppingMallService(ShoppingMallRepo shoppingMallRepo) {
        this.shoppingMallRepo = shoppingMallRepo;
    }

    public void addProduct(Product product){
        shoppingMallRepo.addProduct(product);
    }

    public List<Product> getAllProducts(){
        return shoppingMallRepo.getAllProducts();
    }
}
