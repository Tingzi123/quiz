package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String imgSrc;

    String name;

    Integer price;

    String unit;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    List<OrderEntity> orders;
}
