package com.learn.packt.modernapi.ecommerce.controllers;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import com.learn.packt.modernapi.api.CustomerApi;
import com.learn.packt.modernapi.ecommerce.hateoas.AddressRepresentationModelAssembler;
import com.learn.packt.modernapi.ecommerce.hateoas.CardRepresentationModelAssembler;
import com.learn.packt.modernapi.ecommerce.hateoas.UserRepresentationModelAssembler;
import com.learn.packt.modernapi.api.model.Address;
import com.learn.packt.modernapi.api.model.Card;
import com.learn.packt.modernapi.api.model.User;
import com.learn.packt.modernapi.ecommerce.service.UserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
@RestController
public class CustomerController implements CustomerApi {

  private final UserRepresentationModelAssembler assembler;
  private final AddressRepresentationModelAssembler addrAssembler;
  private final CardRepresentationModelAssembler cardAssembler;
  private UserService service;

  public CustomerController(UserService service, UserRepresentationModelAssembler assembler,
      AddressRepresentationModelAssembler addrAssembler,
      CardRepresentationModelAssembler cardAssembler) {
    this.service = service;
    this.assembler = assembler;
    this.addrAssembler = addrAssembler;
    this.cardAssembler = cardAssembler;
  }

  @Override
  public ResponseEntity<Void> deleteCustomerById(String id) {
    service.deleteCustomerById(id);
    return accepted().build();
  }

  @Override
  public ResponseEntity<List<Address>> getAddressesByCustomerId(String id) {
    return service.getAddressesByCustomerId(id).map(addrAssembler::toListModel)
        .map(ResponseEntity::ok).orElse(notFound().build());
  }

  @Override
  public ResponseEntity<List<User>> getAllCustomers() {
    return ok(assembler.toListModel(service.getAllCustomers()));
  }

  @Override
  public ResponseEntity<List<Card>> getCardByCustomerId(String id) {
    return ok(cardAssembler.toListModel(service.getCardByCustomerId(id)));
  }

  @Override
  public ResponseEntity<User> getCustomerById(String id) {
    return service.getCustomerById(id).map(assembler::toModel).map(ResponseEntity::ok)
        .orElse(notFound().build());
  }
}
