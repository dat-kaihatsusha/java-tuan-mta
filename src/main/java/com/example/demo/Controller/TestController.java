package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

  @GetMapping(value = "/test-rest-template")
  ResponseEntity<?> testRestTemplate(){
    RestTemplate restTemplate = new RestTemplate();

    /*Get user detail*/
    String url = "http://127.0.0.1:8081/users/1";
    ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);

    /*update user*/
    String url1 = "http://127.0.0.1:8081/users";
    Integer id = 2;
    User userUpdate = new User(2, "dat02", "datnguyentien", "123");
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "application/json");
    HttpEntity<User> requestEntity = new HttpEntity<>(userUpdate, headers);
    ResponseEntity<User> response1 = restTemplate.exchange(
        url1,
        HttpMethod.PUT,
        requestEntity,
        User.class
    );

    /*create user*/
    String url2 = "http://127.0.0.1:8081/users";
    User userCreate = new User();
    userCreate.setName("abc");
    userCreate.setUserName("nguyenAbc");
    userCreate.setPassword("123");
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("Content-Type", "application/json");
    HttpEntity<User> requestEntity2 = new HttpEntity<>(userCreate, httpHeaders);
    ResponseEntity<String> response2 = restTemplate.exchange(
        url2,
        HttpMethod.POST,
        requestEntity2,
        String.class
    );

    /*get list user*/
    String url3 = "http://127.0.0.1:8081/users";
    ResponseEntity<List<User>> response3 = restTemplate.exchange(
        url3,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<User>>() {}
    );

    return new ResponseEntity<>(response3.getBody(), HttpStatus.OK);
  }
}
