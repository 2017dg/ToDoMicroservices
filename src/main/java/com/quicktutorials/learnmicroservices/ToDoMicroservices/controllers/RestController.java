package com.quicktutorials.learnmicroservices.ToDoMicroservices.controllers;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.ToDo;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.User;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.services.LoginService;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.utilities.JsonResponseBody;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.utilities.ToDoValidator;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.utilities.UserNotInDatabaseException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	LoginService loginService;
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello controller"; // "hello"-> hello.jsp is searched by ViewResolver if u don't put @ResponseBody
	}

	@RequestMapping("/userInOutput")
	public User giveMeAUser() {
		return new User("sadeshpandit@hotmail.com", "Sandesh pandit", "hello");

	}

	@RequestMapping("/todoInInput1")
	public String toDoInInput1(ToDo toDo) {
		return "ToDo Description: " + toDo.getDescription() + ", Todo priority " + toDo.getPriority();

	}

	@RequestMapping("/todoInInput2")
	public String toDoInInput2(@Valid ToDo toDo) {
		return "ToDo Description: " + toDo.getDescription() + ", Todo priority " + toDo.getPriority();
	}

	@RequestMapping("/todoInInput3")
	public String toDoInInput3(ToDo toDo, BindingResult result) {
		if (result.hasErrors()) {
			return "I return the error in the format I like : "+result.toString();
		}
		return "ToDo Description: " + toDo.getDescription() + ", Todo priority " + toDo.getPriority();
	}

	@RequestMapping("/todoInInput4")
	public String toDoInInput4(ToDo toDo, BindingResult result) {
		ToDoValidator validator = new ToDoValidator();
		validator.validate(toDo, result);
		if (result.hasErrors()) {
			return "I return the error in the format I like : "+result.toString();
		}
		return "ToDo Description: " + toDo.getDescription() + ", Todo priority " + toDo.getPriority();
	}
	@RequestMapping("/todoInInput5")
	public String toDoInInput5(@Valid ToDo toDo, BindingResult result) {
		ToDoValidator validator = new ToDoValidator();
		validator.validate(toDo, result);
		if (result.hasErrors()) {
			return "I return the error in the format I like : "+result.toString();
		}
		return "ToDo Description: " + toDo.getDescription() + ", Todo priority " + toDo.getPriority();
	}
	
	/*@RequestMapping("/exampleUrl")
    public ResponseEntity<JsonResponseBody> returnMyStandardResponse(){
        return ResponseEntity.status(HttpStatus.OK).header("jwt", jwt).body( new JsonResponseBody());
    }*/
	
	
	@RequestMapping(value = "/login", method= POST)
    public ResponseEntity<JsonResponseBody> login(@RequestParam(value="email") String email, @RequestParam(value="password") String pwd){

        //1) success: return a String with the login message + JWT in the HEADER of the HTTP RESPONSE
        //2) return the error message
        try {
            Optional<User> userr = loginService.getUserFromDb(email, pwd);
            User user = userr.get();
            String jwt = loginService.createJwt(email, user.getName(), new Date());
            //the only case in which the server sends the JWT to the client in the HEADER of the RESPONSE
            return ResponseEntity.status(HttpStatus.OK).header("jwt", jwt).body(new JsonResponseBody(HttpStatus.OK.value(), "Success! User logged in!"));
        }catch(UserNotInDatabaseException e1){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Forbidden: " + e1.toString()));
        }catch(UnsupportedEncodingException e2){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Bad Request: " + e2.toString()));
        }
    }
	
	
}
