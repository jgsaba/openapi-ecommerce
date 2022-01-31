package com.learn.packt.modernapi.ecommerce.service;

import com.learn.packt.modernapi.ecommerce.entity.CardEntity;
import com.learn.packt.modernapi.ecommerce.entity.UserEntity;
import com.learn.packt.modernapi.api.model.AddCardReq;
import com.learn.packt.modernapi.ecommerce.repository.CardRepository;
import com.learn.packt.modernapi.ecommerce.repository.UserRepository;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.stereotype.Service;


@Service
public class CardServiceImpl implements CardService {
  private CardRepository repository;
  private UserRepository userRepo;

  public CardServiceImpl(CardRepository repository, UserRepository userRepo) {
    this.repository = repository;
    this.userRepo = userRepo;
  }

  @Override
  public void deleteCardById(String id) {
    repository.deleteById(UUID.fromString(id));
  }

  @Override
  public Iterable<CardEntity> getAllCards() {
    return repository.findAll();
  }

  @Override
  public Optional<CardEntity> getCardById(String id) {
    return repository.findById(UUID.fromString(id));
  }

  @Override
  public Optional<CardEntity> registerCard(@Valid AddCardReq addCardReq) {
    // add validation to make sure that only single card exists from one user
    // else it throw DataIntegrityViolationException for user_id (unique)
    return Optional.of(repository.save(toEntity(addCardReq)));
  }

  private CardEntity toEntity(AddCardReq m) {
    CardEntity e = new CardEntity();
    Optional<UserEntity> user = userRepo.findById(UUID.fromString(m.getUserId()));
    user.ifPresent(u -> e.setUser(u));

    e.setNumber(m.getCardNumber());
    e.setCvv(m.getCvv());
    e.setExpires(m.getExpires());

    return e;
  }
}
