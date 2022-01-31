package com.learn.packt.modernapi.ecommerce.service;

import com.learn.packt.modernapi.ecommerce.entity.ProductEntity;
import com.learn.packt.modernapi.ecommerce.repository.ProductRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  private ProductRepository repository;

  public ProductServiceImpl(ProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<ProductEntity> getAllProducts() {
    return repository.findAll();
  }

  @Override
  public Optional<ProductEntity> getProduct(String id) {
    return repository
        .findById(UUID.fromString(id));
  }
}
