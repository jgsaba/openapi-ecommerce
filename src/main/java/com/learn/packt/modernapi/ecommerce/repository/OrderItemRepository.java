package com.learn.packt.modernapi.ecommerce.repository;

import java.util.UUID;

import com.learn.packt.modernapi.ecommerce.entity.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItemEntity, UUID> {
}
