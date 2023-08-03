package com.example.demo.Repository1;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository1 extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * from user", nativeQuery = true)
    List<User> findALlUser();

    @Query(value = "select * from user where id = :id", nativeQuery = true)
    List<User> findUserById(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "insert into user(id, name) values (:id, :name)", nativeQuery = true)
    Integer addNewUser(@Param("id") String id, @Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "update user set name = :name where id = :id", nativeQuery = true)
    Integer updateUser(@Param("name") String name, @Param("id") String id);


    @Transactional
    @Modifying
    @Query(value = "insert into user(name, username, password) value(:name, :username, :password) ", nativeQuery = true)
    void importUserThread(@Param("name") String name, @Param("username") String username, @Param("password") String password);
}
