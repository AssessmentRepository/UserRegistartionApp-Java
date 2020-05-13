package com.userregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userregistration.model.User;
import com.userregistration.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	// test controller
	@GetMapping("/hi")
	public String hiMessage() {
		return "Hi User Registration...";
	}

	@PostMapping("/registere")
	public ResponseEntity<?> save(@RequestBody User user) {
		return null;		
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> get(@PathVariable("id") int userId) {
		return null;		
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> list() {
		return null;		
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody User user) {
		return null;
		
	}

	@DeleteMapping("/User/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		return null;		
	}
}
