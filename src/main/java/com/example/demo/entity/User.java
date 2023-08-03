package com.example.demo.entity;

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
@Table(schema = "hello", name="user")
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
