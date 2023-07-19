package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
  @Id
  Integer id;

  @Column(name = "name")
  String name;

  @Column(name = "userName")
  String userName;

  @Column(name = "password")
  String password;
}
