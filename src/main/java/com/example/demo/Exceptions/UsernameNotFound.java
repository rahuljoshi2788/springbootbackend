package com.example.demo.Exceptions;

@SuppressWarnings("serial")
public class UsernameNotFound extends RuntimeException {

	public UsernameNotFound(String message){
		
		super("Could not find user " + message);
	}
	
}
