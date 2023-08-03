package com.example.demo.Service.Impl;

import com.example.demo.entity.User;
import com.example.demo.Repository1.UserRepository1;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository1 userRepository;

  @Override
  public User updateUser(User user) throws Exception {
    Optional<User> userById = userRepository.findById(user.getId());
    if (!userById.isPresent()) {
      throw new Exception();
    }
    userById.get().setId(user.getId());
    userById.get().setName(user.getName());
    userRepository.save(userById.get());
    Optional<User> user1 = userRepository.findById(user.getId());
    return user1.get();
  }
}
