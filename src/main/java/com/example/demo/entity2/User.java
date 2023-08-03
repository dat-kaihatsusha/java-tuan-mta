package com.example.demo.entity2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "hello2", name = "user")
public class User {
  @Id
  Integer id;

  @Column(name = "name")
  String name;

  @Column(name = "username")
  String userName;

  @Column(name = "password")
  String password;
}
