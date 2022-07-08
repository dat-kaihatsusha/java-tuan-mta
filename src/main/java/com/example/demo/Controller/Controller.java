package com.example.demo.Controller;

import com.example.demo.Entity.Item;
import com.example.demo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/api/items")
public class Controller {

  @Autowired
  ItemService itemService;

  @GetMapping()
  public ResponseEntity<List<Item>> getAllItem() {

    return ResponseEntity.ok(itemService.getAll());
  }

  @GetMapping("/id")
  public ResponseEntity<Integer> findIdByName(@RequestParam("name") String name) {
    Integer id = itemService.findItemIdByName(name);
    return new ResponseEntity<>(id, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Item> findById(@PathVariable Integer id) {
    return ResponseEntity.ok(itemService.getItemById(id));
  }

  @PostMapping()
  public  ResponseEntity<Item> postItem(@RequestBody Item item) {
    return ResponseEntity.ok(itemService.add(item));
  }
}
