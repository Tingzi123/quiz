package com.twuc.shopping.repository;

import com.twuc.shopping.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingMallRepo extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findAll();
}
