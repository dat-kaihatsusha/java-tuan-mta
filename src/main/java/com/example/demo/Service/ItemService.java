package com.example.demo.Service;

public interface ItemService {
  Integer findItemIdByName(String name);

  void postItem(Integer id, String name);
}
