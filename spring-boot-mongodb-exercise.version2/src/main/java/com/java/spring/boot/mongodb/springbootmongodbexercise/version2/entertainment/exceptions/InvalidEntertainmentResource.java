package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEntertainmentResource extends RuntimeException{
	public InvalidEntertainmentResource(String message){
		super (message);
	}
}
