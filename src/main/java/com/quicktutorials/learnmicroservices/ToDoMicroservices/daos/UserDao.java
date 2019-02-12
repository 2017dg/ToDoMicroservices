package com.quicktutorials.learnmicroservices.ToDoMicroservices.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.User;


public interface UserDao extends JpaRepository<User, String>{
//name strategy
	Optional<User> findUserByEmail(String email);
	/*//query annotation
	@Query(value="SELECT * FROm users where email=:email", nativeQuery=true)
	Optional<User> findUserByTheEmail(@Param("email") String email);
	
	//native method
	User findOne(String email);*/

	
}
