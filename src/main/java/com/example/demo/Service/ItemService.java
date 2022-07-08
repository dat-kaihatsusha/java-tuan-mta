package com.example.demo.Service;

import com.example.demo.Entity.Item;

import java.util.List;

public interface ItemService {
  Integer findItemIdByName(String name);

  void postItem(Integer id, String name);

  Item getItemById(Integer id);

  List<Item> getAll();

  Item add(Item item);
}
