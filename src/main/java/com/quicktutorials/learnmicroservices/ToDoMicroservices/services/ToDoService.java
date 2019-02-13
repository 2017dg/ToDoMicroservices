package com.quicktutorials.learnmicroservices.ToDoMicroservices.services;

import java.util.List;

import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.ToDo;

public interface ToDoService {
	List<ToDo> getToDos(String email);

    ToDo addToDo(ToDo toDo);

    void deleteToDo(Integer id);
}
