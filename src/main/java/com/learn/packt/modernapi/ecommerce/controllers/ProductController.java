package com.learn.packt.modernapi.ecommerce.controllers;

import static org.springframework.http.ResponseEntity.ok;

import com.learn.packt.modernapi.api.ProductApi;
import com.learn.packt.modernapi.api.model.Product;
import com.learn.packt.modernapi.ecommerce.hateoas.ProductRepresentationModelAssembler;
import com.learn.packt.modernapi.ecommerce.service.ProductService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
@RestController
public class ProductController implements ProductApi {

  private ProductService service;
  private final ProductRepresentationModelAssembler assembler;

  public ProductController(ProductService service, ProductRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<Product> getProduct(String id) {
    return service.getProduct(id).map(assembler::toModel).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @Override
  public ResponseEntity<List<Product>> queryProducts(@Valid String tag, @Valid String name,
      @Valid Integer page, @Valid Integer size) {
    return ok(assembler.toListModel(service.getAllProducts()));
  }
}
