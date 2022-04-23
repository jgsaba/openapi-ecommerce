package com.learn.packt.modernapi.ecommerce.controllers;

import com.learn.packt.modernapi.api.PaymentApi;
import com.learn.packt.modernapi.ecommerce.hateoas.PaymentRepresentationModelAssembler;
import com.learn.packt.modernapi.api.model.Authorization;
import com.learn.packt.modernapi.api.model.PaymentReq;
import com.learn.packt.modernapi.ecommerce.service.PaymentService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
@RestController
public class PaymentController implements PaymentApi {

  private PaymentService service;
  private final PaymentRepresentationModelAssembler assembler;

  public PaymentController(PaymentService service, PaymentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<Authorization> authorize(@Valid PaymentReq paymentReq) {
    return null;
  }

  @Override
  public ResponseEntity<Authorization> getOrdersPaymentAuthorization(
      @NotNull @Valid String id) {
    return null;
  }
}
