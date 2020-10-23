package com.twuc.shopping.repository;

import com.twuc.shopping.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAll();
}
