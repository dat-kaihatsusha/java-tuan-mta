package com.example.demo.Controller;

import com.example.demo.Entity.Item;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.ItemService;
import com.example.demo.dto.ImportUserServiceThread;
import com.example.demo.dto.UserDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController

@RequestMapping("/api/items")
public class Controller {

  @Autowired
  ItemService itemService;

  @Autowired
  UserRepository userRepository;

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
  public ResponseEntity<Item> postItem(@RequestBody Item item) {
    return ResponseEntity.ok(itemService.add(item));
  }

  @GetMapping("/test-multiple-threading")
  public ResponseEntity<?> testMultipleThreading() {
    String filePath = "D:\\2-self-learn\\java-tuan-mta\\Book1.xlsx";
    try {
      FileInputStream fis = new FileInputStream(new File(filePath));
      Workbook workbook = new XSSFWorkbook(fis);
      Sheet sheet = workbook.getSheetAt(0);
      ExecutorService executor = Executors.newFixedThreadPool(2000);
      for (Row row : sheet) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(String.valueOf(row.getCell(0)));
        userDTO.setUsername(String.valueOf(row.getCell(1)));
        userDTO.setPassword(String.valueOf(row.getCell(2)));
        Runnable importUserServiceThread = new ImportUserServiceThread(userDTO, userRepository);
        executor.execute(importUserServiceThread);
      }
      executor.shutdown();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity<>("success", HttpStatus.OK);
  }
}
