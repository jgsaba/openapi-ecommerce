package com.learn.packt.modernapi.ecommerce.service;

import com.learn.packt.modernapi.ecommerce.entity.AuthorizationEntity;
import com.learn.packt.modernapi.api.model.PaymentReq;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public interface PaymentService {

  public Optional<AuthorizationEntity> authorize(@Valid PaymentReq paymentReq);
  public Optional<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId);
}
