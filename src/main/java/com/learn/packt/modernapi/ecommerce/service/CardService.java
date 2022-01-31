package com.learn.packt.modernapi.ecommerce.service;

import com.learn.packt.modernapi.ecommerce.entity.CardEntity;
import com.learn.packt.modernapi.api.model.AddCardReq;
import java.util.Optional;
import javax.validation.Valid;


public interface CardService {
  public void deleteCardById(String id);
  public Iterable<CardEntity> getAllCards();
  public Optional<CardEntity> getCardById(String id);
  public Optional<CardEntity> registerCard(@Valid AddCardReq addCardReq);
}
