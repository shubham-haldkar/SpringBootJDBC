package com.siteinvokers.JDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.siteinvokers.JDBC.DAO.ProgrammerDAO;
import com.siteinvokers.JDBC.model.Programmer;

@SpringBootApplication
public class SpringBootJDBCProjectApplication {

	public static void main(String[] args) {
	 	ApplicationContext context =  SpringApplication.run(SpringBootJDBCProjectApplication.class, args);
		
	 	Programmer prog1 = context.getBean(Programmer.class) ;
	 	
	 	prog1.setId(104);
	 	prog1.setName("Shubham");
	 	prog1.setTech("Python");
	 	
	 	ProgrammerDAO progDao = context.getBean(ProgrammerDAO.class) ;
	 	
	 	progDao.save(prog1);
	 	System.out.println(progDao.findAll());  ;
	 	
	}

}
