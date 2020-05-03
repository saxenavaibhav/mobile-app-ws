package com.saxena.vaibhav.mobileappws.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saxena.vaibhav.mobileappws.common.Utils;
import com.saxena.vaibhav.mobileappws.rest.model.request.UserDetails;
import com.saxena.vaibhav.mobileappws.rest.model.response.User;

@Service
public class UserServiceImpl implements UserService {
	
	private Map<String, User> users;
	
	Utils utils; 
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}
	

	@Override
	public User createUser(UserDetails userDetail) {
		User user = new User();
		user.setEmail(userDetail.getEmail());
		user.setFirstName(userDetail.getFirstName());
		user.setLastName(userDetail.getLastName());
		String userId = UUID.randomUUID().toString();
		user.setId(userId);
		if (users == null) {
			users = new HashMap<>();
		}
		users.put(userId, user);
		return user;
	}

}
