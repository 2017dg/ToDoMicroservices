package com.quicktutorials.learnmicroservices.ToDoMicroservices.controllers;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.ToDo;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.User;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.utilities.ToDoValidator;

@org.springframework.web.bind.annotation.RestController
public class RestController {

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
	
	
	
}
