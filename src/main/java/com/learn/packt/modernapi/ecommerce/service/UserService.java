package com.learn.packt.modernapi.ecommerce.service;

import com.learn.packt.modernapi.ecommerce.entity.AddressEntity;
import com.learn.packt.modernapi.ecommerce.entity.CardEntity;
import com.learn.packt.modernapi.ecommerce.entity.UserEntity;
import java.util.Optional;


public interface UserService {
  public void deleteCustomerById(String id);
  public Optional<Iterable<AddressEntity>> getAddressesByCustomerId(String id);
  public Iterable<UserEntity> getAllCustomers();
  public Optional<CardEntity> getCardByCustomerId(String id);
  public Optional<UserEntity> getCustomerById(String id);
}
