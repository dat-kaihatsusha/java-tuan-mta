package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequestMapping()
@RestController
public class TestController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserServiceImpl userService;

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

  @PutMapping(value = "/users")
  ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
    User result = userService.updateUser(user);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @Bean
  @GetMapping(value = "/test-bean")
  ResponseEntity<?> testBean(){
    System.out.println("run into test-bean");
    return new ResponseEntity<>("success", HttpStatus.OK);
  }
}
