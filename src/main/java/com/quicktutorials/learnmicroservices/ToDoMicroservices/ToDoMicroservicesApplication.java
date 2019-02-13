package com.quicktutorials.learnmicroservices.ToDoMicroservices;

	
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quicktutorials.learnmicroservices.ToDoMicroservices.daos.ToDoDao;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.daos.UserDao;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.ToDo;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.entities.User;
import com.quicktutorials.learnmicroservices.ToDoMicroservices.utilities.EncryptionUtils;




@SpringBootApplication
public class ToDoMicroservicesApplication implements CommandLineRunner{
    @Autowired
    UserDao userDao; //UserDaoImpl UserDao userDao = new UserDaoImpl();
    @Autowired 
    ToDoDao toDoDao;	
	//instead of below line u can use @log from lombok
    @Autowired
    EncryptionUtils encryptUtils;
	
	private static final Logger log = LoggerFactory.getLogger(ToDoMicroservicesApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ToDoMicroservicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
   log.info("lets fill H2 in memory");
   //everything will be implemented before our Microservice will be available for HTTP Requests
   String encryptedPwd;
   encryptedPwd = encryptUtils.encrypt("Hello");
   userDao.save(new User("sandeshpandit@hotmail.com", "Sandesh pandit", encryptedPwd));
   encryptedPwd = encryptUtils.encrypt("sandy");
   userDao.save(new User("sandy@hotmail.com", "Sandy", encryptedPwd));
   encryptedPwd = encryptUtils.encrypt("anku");
   userDao.save(new User("anku@hotmail.com", "anku", encryptedPwd));
  // toDoDao.save(new ToDo());
   toDoDao.save( new ToDo(1, "Learn Microservice", new Date(), "high", "sandeshpandit@hotmail.com"));
   toDoDao.save( new ToDo(null, "Learn Microservice", new Date(), "low", "sandeshpandit@hotmail.com"));

   toDoDao.save( new ToDo(3, "Learn Spring Boot", new Date(), "high", "sandy@hotmail.com"));
   toDoDao.save( new ToDo(null, "Learn java", null, "low", "sandy@hotmail.com"));

   
    log.info("we have finished filling databaseS");
		
	}

}

