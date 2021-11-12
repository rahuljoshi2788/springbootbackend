package com.example.demo.Exceptions;

@SuppressWarnings("serial")
public class UsernameNotFound extends RuntimeException {

	UsernameNotFound(Integer id){
		
		super("Could not find user" + id);
	}
	
}
