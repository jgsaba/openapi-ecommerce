package com.learn.packt.modernapi.ecommerce.service;

import com.learn.packt.modernapi.ecommerce.entity.ItemEntity;
import com.learn.packt.modernapi.api.model.Item;
import java.util.List;


public interface ItemService {

  ItemEntity toEntity(Item m);

  List<ItemEntity> toEntityList(List<Item> items);

  Item toModel(ItemEntity e);

  List<Item> toModelList(List<ItemEntity> items);
}
