package com.learn.packt.modernapi.ecommerce.controllers;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import com.learn.packt.modernapi.api.OrderApi;
import com.learn.packt.modernapi.ecommerce.hateoas.OrderRepresentationModelAssembler;
import com.learn.packt.modernapi.api.model.NewOrder;
import com.learn.packt.modernapi.api.model.Order;
import com.learn.packt.modernapi.ecommerce.service.OrderService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
@RestController
public class OrderController implements OrderApi {

  private final OrderRepresentationModelAssembler assembler;
  private OrderService service;

  public OrderController(OrderService service, OrderRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<Order> addOrder(@Valid NewOrder newOrder) {
    return service.addOrder(newOrder).map(assembler::toModel).map(ResponseEntity::ok)
        .orElse(notFound().build());
  }

  @Override
  public ResponseEntity<List<Order>> getOrdersByCustomerId(@NotNull @Valid String customerId) {
    return ok(assembler.toListModel(service.getOrdersByCustomerId(customerId)));
  }

  @Override
  public ResponseEntity<Order> getByOrderId(String id) {
    return service.getByOrderId(id).map(assembler::toModel).map(ResponseEntity::ok)
        .orElse(notFound().build());
  }
}
