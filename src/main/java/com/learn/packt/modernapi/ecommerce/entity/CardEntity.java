package com.learn.packt.modernapi.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "card")
public class CardEntity {
  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "NUMBER")
  private String number;

  @Column(name = "EXPIRES")
  private String expires;

  @Column(name = "CVV")
  private String cvv;

  @ManyToOne
  @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
  private UserEntity user;

  @OneToMany(mappedBy = "cardEntity", fetch = FetchType.LAZY, orphanRemoval = true)
  private List<OrderEntity> orders;
}