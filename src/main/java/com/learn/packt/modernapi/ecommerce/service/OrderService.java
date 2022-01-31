package com.learn.packt.modernapi.ecommerce.service;

import com.learn.packt.modernapi.ecommerce.entity.OrderEntity;
import com.learn.packt.modernapi.api.model.NewOrder;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public interface OrderService {

  public Optional<OrderEntity> addOrder(@Valid NewOrder newOrder);
  public Iterable<OrderEntity> getOrdersByCustomerId(@NotNull @Valid String customerId);
  public Optional<OrderEntity> getByOrderId(String id);
}
