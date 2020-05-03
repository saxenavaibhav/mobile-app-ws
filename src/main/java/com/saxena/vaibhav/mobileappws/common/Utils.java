package com.saxena.vaibhav.mobileappws.common;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	public String generateUserId() {
		return UUID.randomUUID().toString();
	}
}
