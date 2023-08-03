package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

  @Id
  Integer id;

  String name;

  @Column(name = "user_id")
  Integer user_id; //userId

  public Item(Integer id, String name, Integer user_id) {
    this.id = id;
    this.name = name;
    this.user_id = user_id;
  }

  public Item() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }
}
