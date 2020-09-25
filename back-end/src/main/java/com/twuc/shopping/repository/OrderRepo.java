package com.twuc.shopping.repository;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.dto.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepo {
    public static List<Order> orders=new ArrayList<>();

    public List<Order> getAllOrder(){
        return orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }
}
