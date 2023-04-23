package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * from users", nativeQuery = true)
    List<User> findALlUser();

    @Query(value = "select * from users where id = :id", nativeQuery = true)
    List<User> findUserById(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "insert into users(id, name) values (:id, :name)", nativeQuery = true)
    Integer addNewUser(@Param("id") String id, @Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "update users set name = :name where id = :id", nativeQuery = true)
    Integer updateUser(@Param("name") String name, @Param("id") String id);
}
