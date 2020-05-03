package com.saxena.vaibhav.mobileappws.rest.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.saxena.vaibhav.mobileappws.rest.model.request.UpdateUserDetails;
import com.saxena.vaibhav.mobileappws.rest.model.request.UserDetails;
import com.saxena.vaibhav.mobileappws.rest.model.response.User;
import com.saxena.vaibhav.mobileappws.service.UserService;

@RestController
@RequestMapping("users")
public class UserRestController {

	private Map<String, User> users;
	
	@Autowired
	private UserService userService;

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(value = "limit", defaultValue = "50") String limit) {
		return "Get users was called with page: " + page + " and limit: " + limit;
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUser(@PathVariable String id) {
		if (users.containsKey(id)) {
			return new ResponseEntity<User>(users.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDetails userDetail) {
		
		return new ResponseEntity<User>(userService.createUser(userDetail), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> updateUser(@PathVariable String id, @Valid @RequestBody UpdateUserDetails updateUserDetils) {
		User user = users.get(id);
		user.setFirstName(updateUserDetils.getFirstName());
		user.setLastName(updateUserDetils.getLastName());
		users.put(id, user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.noContent().build();
	}

}
