package com.example.demo.Repository;

import com.example.demo.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Integer> {

  @Query(value = "SELECT id FROM items WHERE name = :paramName", nativeQuery = true)
  Integer findIdByName(@Param("paramName") String paramName);

//  @Query(value = "SELECT id FROM items WHERE id = :paramId", nativeQuery = true)
//  Item findItemById(@Param("paramName") String paramName);
  Item findItemById(Integer id);
}
