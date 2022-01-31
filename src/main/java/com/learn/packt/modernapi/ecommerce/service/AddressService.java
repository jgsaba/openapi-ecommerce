package com.learn.packt.modernapi.ecommerce.service;

import com.learn.packt.modernapi.api.model.AddAddressReq;
import com.learn.packt.modernapi.ecommerce.entity.AddressEntity;
import java.util.Optional;


public interface AddressService {
  public Optional<AddressEntity> createAddress(AddAddressReq addAddressReq);
  public void deleteAddressesById(String id);
  public Optional<AddressEntity> getAddressesById(String id);
  public Iterable<AddressEntity> getAllAddresses();
}
