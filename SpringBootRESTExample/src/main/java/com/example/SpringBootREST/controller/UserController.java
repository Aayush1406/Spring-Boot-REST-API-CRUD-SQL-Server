package com.example.SpringBootREST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootREST.entity.User;
import com.example.SpringBootREST.repository.UserRepo;


@RestController
public class UserController {

	@Autowired 
	UserRepo userRepo;
	
	
	@GetMapping("/findAll")
	public List<User> getAllUser(){
		return userRepo.findAll();
	}

	@PostMapping("/saveUser")
	public User insert(@RequestBody User user) {
		System.out.println("user name = "+user.getName());
		return userRepo.save(user);
		
	}	
	
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userRepo.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User user) {
		User retrievedUser = userRepo.findById(id).orElse(null);
		
		if(user!=null) {
			retrievedUser.setName(user.getName());
			retrievedUser.setAge(user.getAge());
			return userRepo.save(retrievedUser);
		}
		
		return null;
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepo.deleteById(id);
	}
}


