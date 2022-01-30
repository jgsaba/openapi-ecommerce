package com.learn.packt.modernapi.ecommerce.repository;

import java.util.UUID;

import com.learn.packt.modernapi.ecommerce.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, UUID> {
}

