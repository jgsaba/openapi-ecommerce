package com.learn.packt.modernapi.ecommerce.repository;

import java.util.Optional;
import java.util.UUID;

import com.learn.packt.modernapi.ecommerce.entity.CartEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<CartEntity, UUID> {

  @Query("select c from CartEntity c join c.user u where u.id = :customerId")
  Optional<CartEntity> findByCustomerId(@Param("customerId") UUID customerId);

}
