package com.learn.packt.modernapi.ecommerce.entity;

import com.learn.packt.modernapi.api.model.Order;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {
  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "TOTAL")
  private BigDecimal total;

  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  private Order.StatusEnum status;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "CUSTOMER_ID", nullable = false)
  private UserEntity userEntity;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID", insertable = false, updatable = false)
  private AddressEntity addressEntity;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "PAYMENT_ID", referencedColumnName = "ID")
  private PaymentEntity paymentEntity;

  @JoinColumn(name = "SHIPMENT_ID", referencedColumnName = "ID")
  @OneToOne
  private ShipmentEntity shipment;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "CARD_ID", referencedColumnName = "ID")
  private CardEntity cardEntity;

  @Column(name = "ORDER_DATE")
  private Timestamp orderDate;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(
          name = "ORDER_ITEM",
          joinColumns = @JoinColumn(name = "ORDER_ID"),
          inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
  )
  private List<ItemEntity> items = Collections.emptyList();

  @OneToOne(mappedBy = "orderEntity")
  private AuthorizationEntity authorizationEntity;
}