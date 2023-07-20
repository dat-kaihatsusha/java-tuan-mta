package com.example.demo.dto;

import com.example.demo.Repository.UserRepository;

public class ImportUserServiceThread implements Runnable {

  private UserDTO userDTO1;
  private UserRepository userRepository;

  public ImportUserServiceThread(UserDTO userDTO, UserRepository userRepository) {
    this.userDTO1 = userDTO;
    this.userRepository = userRepository;
  }

  @Override
  public void run() {
    userRepository.importUserThread(this.userDTO1.getName(), this.userDTO1.getUsername(), this.userDTO1.getPassword());
  }
}
