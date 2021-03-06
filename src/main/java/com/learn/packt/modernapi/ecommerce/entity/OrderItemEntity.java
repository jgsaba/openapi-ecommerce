package com.learn.packt.modernapi.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@Table(name = "order_item")
public class OrderItemEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "order_id")
  private UUID orderId;

  @Column(name = "item_id")
  private UUID itemId;

  public OrderItemEntity setId(UUID id) {
    this.id = id;
    return this;
  }

  public OrderItemEntity setOrderId(UUID orderId) {
    this.orderId = orderId;
    return this;
  }

  public OrderItemEntity setItemId(UUID itemId) {
    this.itemId = itemId;
    return this;
  }
}
