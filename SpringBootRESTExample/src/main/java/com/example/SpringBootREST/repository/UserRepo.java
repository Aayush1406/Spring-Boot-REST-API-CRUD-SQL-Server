package com.example.SpringBootREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootREST.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
