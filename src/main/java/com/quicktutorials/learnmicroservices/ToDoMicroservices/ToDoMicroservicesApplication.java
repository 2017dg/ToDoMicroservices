package com.quicktutorials.learnmicroservices.ToDoMicroservices;

	
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quicktutorials.learnmicroservices.ToDoMicroservices.daos.ToDoDao;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.daos.UserDao;




@SpringBootApplication
public class ToDoMicroservicesApplication implements CommandLineRunner{
    @Autowired
    UserDao userDao;
    @Autowired 
    ToDoDao toDoDao;	
	//instead of below line u can use @log from lombok
	
	private static final Logger log = LoggerFactory.getLogger(ToDoMicroservicesApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ToDoMicroservicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
   log.info("lets fill H2 in memory");
   
   
    log.info("we have finished filling databaseS");
		
	}

}

