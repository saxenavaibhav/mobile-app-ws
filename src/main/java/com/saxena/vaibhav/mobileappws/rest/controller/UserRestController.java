package com.saxena.vaibhav.mobileappws.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserRestController {

	@GetMapping(path = "/{id}")
	public String getUser(@PathVariable String id) {
		return "Get user was called with ID: " + id;
	}
	
	@PostMapping
	public String createUser() {
		return "Create user was called";
	}
	
	@PutMapping
	public String updateUser() {
		return "Update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete user was called";
	}
	
	
}
