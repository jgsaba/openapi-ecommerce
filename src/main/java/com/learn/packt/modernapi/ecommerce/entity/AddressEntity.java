package com.learn.packt.modernapi.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "address")
public class AddressEntity {
  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "NUMBER")
  private String number;

  @Column(name = "RESIDENCY")
  private String residency;

  @Column(name = "STREET")
  private String street;

  @Column(name = "CITY")
  private String city;

  @Column(name = "STATE")
  private String state;

  @Column(name = "COUNTRY")
  private String country;

  @Column(name = "PINCODE")
  private String pincode;

  @OneToMany(mappedBy = "addressEntity", fetch = FetchType.LAZY, orphanRemoval = true)
  private List<OrderEntity> orders;

  public AddressEntity setId(UUID id) {
    this.id = id;
    return this;
  }

  public AddressEntity setNumber(String number) {
    this.number = number;
    return this;
  }

  public AddressEntity setResidency(String residency) {
    this.residency = residency;
    return this;
  }

  public AddressEntity setStreet(String street) {
    this.street = street;
    return this;
  }

  public AddressEntity setCity(String city) {
    this.city = city;
    return this;
  }

  public AddressEntity setState(String state) {
    this.state = state;
    return this;
  }

  public AddressEntity setCountry(String country) {
    this.country = country;
    return this;
  }

  public AddressEntity setPincode(String pincode) {
    this.pincode = pincode;
    return this;
  }

  public AddressEntity setOrders(List<OrderEntity> orders) {
    this.orders = orders;
    return this;
  }
}
