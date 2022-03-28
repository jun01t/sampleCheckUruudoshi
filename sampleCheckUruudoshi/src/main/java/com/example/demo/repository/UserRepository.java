package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginUser;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer> {

}
