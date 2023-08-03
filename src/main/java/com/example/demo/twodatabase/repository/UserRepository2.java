package com.example.demo.twodatabase.repository;

import com.example.demo.entity2.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository2 extends JpaRepository<User, Integer> {
}
