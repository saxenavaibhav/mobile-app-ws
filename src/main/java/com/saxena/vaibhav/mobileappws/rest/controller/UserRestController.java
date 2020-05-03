package com.saxena.vaibhav.mobileappws.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saxena.vaibhav.mobileappws.rest.model.request.UserDetails;
import com.saxena.vaibhav.mobileappws.rest.model.response.User;

@RestController
@RequestMapping("users")
public class UserRestController {

	@GetMapping
	public String getUsers(@RequestParam (value = "page", defaultValue = "1") String page, 
						   @RequestParam (value = "limit",defaultValue = "50") String limit) {
		return "Get users was called with page: " + page + " and limit: " + limit;
	}
	
	@GetMapping(path = "/{id}", produces = 
									{ MediaType.APPLICATION_XML_VALUE, 
									  MediaType.APPLICATION_JSON_VALUE
									}
	            )
	public ResponseEntity<User> getUser(@PathVariable String id) {
		User user = new User();
		user.setEmail("vaibhav@saxena.com");
		user.setFirstName("Vaibhav");
		user.setLastName("Saxena");
		user.setId("1");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping(consumes = {
				MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE
			},
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
			})
	public User createUser(@RequestBody UserDetails userDetail) {
		User user = new User();
		user.setEmail(userDetail.getEmail());
		user.setFirstName(userDetail.getFirstName());
		user.setLastName(userDetail.getLastName());
		return user;
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
