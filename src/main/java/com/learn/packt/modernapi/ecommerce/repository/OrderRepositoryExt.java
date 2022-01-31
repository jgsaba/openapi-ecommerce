package com.learn.packt.modernapi.ecommerce.repository;

import com.learn.packt.modernapi.api.model.NewOrder;
import com.learn.packt.modernapi.ecommerce.entity.OrderEntity;

import java.util.Optional;

public interface OrderRepositoryExt {
    Optional<OrderEntity> insert(NewOrder m);
}
