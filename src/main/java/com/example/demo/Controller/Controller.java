package com.example.demo.Controller;

import com.example.demo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("api/test")
public class Controller {

  @Autowired
  ItemService itemService;

  @GetMapping()
  public List<String> getAllItem() {
    List<String> a =  new ArrayList<>();
    a.add("iphone");
    return a;
  }

  @GetMapping("/{name}")
  public ResponseEntity<Integer> findIdByName(@PathVariable String name) {
    Integer id = itemService.findItemIdByName(name);
    return new ResponseEntity<>(id, HttpStatus.OK);
  }

  @PutMapping()
  public  ResponseEntity<?> postItem(@RequestParam Integer id, @RequestParam String name) {

    itemService.postItem(id, name);
    return new ResponseEntity<>( HttpStatus.OK);
  }
}
