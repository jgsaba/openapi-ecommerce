package com.learn.packt.modernapi.ecommerce.controllers;

import com.learn.packt.modernapi.api.CartApi;
import com.learn.packt.modernapi.api.model.Cart;
import com.learn.packt.modernapi.api.model.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class CartsController implements CartApi {

    @Override
    public ResponseEntity<List<Item>> addCartItemsByCustomerId(String customerId, @Valid Item item) {
        log.info("Request for customer ID: {}\nItem: {}", customerId, item);
        return ResponseEntity.ok(Collections.emptyList());
    }

    @Override
    public ResponseEntity<List<Item>> addOrReplaceItemsByCustomerId(String customerId, Item item) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteCart(String customerId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteItemFromCart(String customerId, String itemId) {
        return null;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return CartApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Cart> getCartByCustomerId(String customerId) {
        return CartApi.super.getCartByCustomerId(customerId);
    }

    @Override
    public ResponseEntity<List<Item>> getCartItemsByCustomerId(String customerId) {
        return CartApi.super.getCartItemsByCustomerId(customerId);
    }

    @Override
    public ResponseEntity<Item> getCartItemsByItemId(String customerId, String itemId) {
        return CartApi.super.getCartItemsByItemId(customerId, itemId);
    }
}
