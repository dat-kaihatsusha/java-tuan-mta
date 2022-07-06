package com.example.demo.Service.Impl;

import com.example.demo.Entity.Item;
import com.example.demo.Repository.ItemRepository;
import com.example.demo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  ItemRepository itemRepository;
  @Override
  public Integer findItemIdByName(String name) {
   return itemRepository.findIdByName(name);
  }

  @Override
  public void postItem(Integer id, String name) {
    Optional<Item> itemNew = itemRepository.findById(id);
    Item item = new Item();
    if (itemNew.isPresent())
       item = itemNew.get();
    item.setName(name);
    itemRepository.save(item);
  }
}
