package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequestMapping()
@RestController
public class TestController {

  @Autowired
  UserRepository userRepository;

  @GetMapping(value = "/test-api")
  ResponseEntity<?> testApi() {
    return new ResponseEntity<>("Done", HttpStatus.OK);
  }

  @GetMapping(value = "/users")
  ResponseEntity<List<User>> getAllUser() {
    List<User> result = userRepository.findALlUser();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping(value = "/users/{id}")
  ResponseEntity<List<User>> getUserById(@PathVariable("id") String id) {
    List<User> result = userRepository.findUserById(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @Transactional
  @PostMapping(value = "/users")
  ResponseEntity<?> addNewUser(@RequestBody User user) {
    Integer result = userRepository.addNewUser(String.valueOf(user.getId()), user.getName());
    return new ResponseEntity<>("succees", HttpStatus.OK);
  }
}
