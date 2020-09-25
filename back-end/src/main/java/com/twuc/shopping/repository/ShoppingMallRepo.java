package com.twuc.shopping.repository;

import com.twuc.shopping.dto.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShoppingMallRepo {
    public static List<Product> products=new ArrayList<>();

    public List<Product> getAllProducts(){
        return products;
    }

    public void addProduct(Product product){
        product.setId(products.size());
        products.add(product);
    }
}
