package com.example.demo.dto;

import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ImportUserServiceThread implements Runnable {

  private UserDTO userDTO1;
  private UserRepository userRepository;

  @Autowired
  public ImportUserServiceThread(UserDTO userDTO, UserRepository userRepository) {
    this.userDTO1 = userDTO;
    this.userRepository = userRepository;
  }

  @Override
  public void run() {
    if (userRepository != null) {
      userRepository.importUserThread(this.userDTO1.getName(), this.userDTO1.getUsername(), this.userDTO1.getPassword());
    } else {
      System.out.println("userRepository == null");
    }
  }
}
