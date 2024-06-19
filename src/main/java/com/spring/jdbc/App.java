package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new 
    		   ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
       
       StudentDao studentDao = context.getBean("dao", StudentDao.class);
       
       List<Student> allStudents = studentDao.getAllStudents();
       
       for(Student student : allStudents) {
    	   System.out.println(student);
       }
       
    }
}
