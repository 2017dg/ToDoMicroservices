package com.quicktutorials.learnmicroservices.ToDoMicroservices.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.User;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.utilities.UserNotInDatabaseException;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.utilities.UserNotLoggedException;

public interface LoginService {

	Optional<User> getUserFromDb(String email, String pwd ) throws UserNotInDatabaseException;
	
	String createJwt(String email, String name, Date date) throws UnsupportedEncodingException;

    Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws  UnsupportedEncodingException, UserNotLoggedException;

}
