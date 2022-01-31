package com.learn.packt.modernapi.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "item")
public class ItemEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
  private ProductEntity product;

  @Column(name = "UNIT_PRICE")
  private BigDecimal price;

  @Column(name = "QUANTITY")
  private int quantity;

  @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
  private List<CartEntity> cart;

  @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
  private List<OrderEntity> orders;

  public ItemEntity setId(UUID id) {
    this.id = id;
    return this;
  }

  public ItemEntity setProduct(ProductEntity product) {
    this.product = product;
    return this;
  }

  public ItemEntity setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public ItemEntity setQuantity(int quantity) {
    this.quantity = quantity;
    return this;
  }

  public ItemEntity setCart(List<CartEntity> cart) {
    this.cart = cart;
    return this;
  }

  public ItemEntity setOrders(List<OrderEntity> orders) {
    this.orders = orders;
    return this;
  }
}