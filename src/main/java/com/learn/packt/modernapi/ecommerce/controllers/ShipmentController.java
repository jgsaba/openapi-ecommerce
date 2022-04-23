package com.learn.packt.modernapi.ecommerce.controllers;

import com.learn.packt.modernapi.api.ShipmentApi;
import com.learn.packt.modernapi.ecommerce.hateoas.ShipmentRepresentationModelAssembler;
import com.learn.packt.modernapi.api.model.Shipment;
import com.learn.packt.modernapi.ecommerce.service.ShipmentService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
@RestController
public class ShipmentController implements ShipmentApi {

  private ShipmentService service;
  private final ShipmentRepresentationModelAssembler assembler;

  public ShipmentController(ShipmentService service, ShipmentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<List<Shipment>> getShipmentByOrderId(@NotNull @Valid String id) {
    return ResponseEntity.ok(assembler.toListModel(service.getShipmentByOrderId(id)));
  }
}
