package com.quicktutorials.learnmicroservices.ToDoMicroservices.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.ToDo;

public interface ToDoDao extends JpaRepository<ToDo, Integer>{
	
	//name strategy
	List<ToDo> findByFkUser(String email);

	void delete(Integer id);

}
