package com.springproject.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String name, String password) {
		boolean isValidUsername = name.equalsIgnoreCase("Gagan");
		boolean isValidPassword = password.equalsIgnoreCase("pa55w0rd");
		
		return isValidUsername && isValidPassword;
	}
}