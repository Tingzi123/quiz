package com.twuc.shopping.repository;

import com.twuc.shopping.entity.CartEntity;
import com.twuc.shopping.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends CrudRepository<CartEntity, Integer> {
    ProductEntity findOneByProductId(Integer productId);
}
