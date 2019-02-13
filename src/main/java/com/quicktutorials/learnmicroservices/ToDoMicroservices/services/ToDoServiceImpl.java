package com.quicktutorials.learnmicroservices.ToDoMicroservices.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quicktutorials.learnmicroservices.ToDoMicroservices.daos.ToDoDao;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.ToDo;

@Service
public class ToDoServiceImpl implements ToDoService{

	 @Autowired
	    ToDoDao toDoDao;

	    @Override
	    public List<ToDo> getToDos(String email){
	        return toDoDao.findByFkUser(email);
	    }

	    @Override
	    public ToDo addToDo(ToDo toDo){
	        return toDoDao.save(toDo);
	    }

	    @Override
	    public void deleteToDo( Integer id){
	        toDoDao.delete(id);
	    	
	    }

		

}	
