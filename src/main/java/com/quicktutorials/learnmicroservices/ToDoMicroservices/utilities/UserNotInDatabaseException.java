package com.quicktutorials.learnmicroservices.ToDoMicroservices.utilities;

public class UserNotInDatabaseException extends Exception{

	public UserNotInDatabaseException(String message) {
		super(message);
	}
	
}
