package com.quicktutorials.learnmicroservices.ToDoMicroservices.utilities;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.ToDo;

//using spring validator
public class ToDoValidator implements Validator{
	 @Override
	    public boolean supports(Class<?> clazz) {
	        return ToDo.class.equals(clazz);
	    }

	    @Override
	    public void validate(Object obj, Errors errors) {
	        ToDo toDo = (ToDo) obj;

	        String priority = toDo.getPriority();

	        if(!"high".equals(priority) && !"low".equals(priority)){
	            errors.rejectValue("priority", "Priority must be 'high' or 'low'!");
	        }

	    }
}
