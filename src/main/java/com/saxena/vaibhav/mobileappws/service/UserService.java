package com.saxena.vaibhav.mobileappws.service;

import com.saxena.vaibhav.mobileappws.rest.model.request.UserDetails;
import com.saxena.vaibhav.mobileappws.rest.model.response.User;

public interface UserService {

	User createUser(UserDetails userDetail);
}
