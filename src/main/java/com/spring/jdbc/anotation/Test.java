package com.spring.jdbc.anotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.anotation.dao.EmployeeDao;
import com.spring.jdbc.anotation.entities.Employee;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(com.spring.jdbc.anotation.JavaConfig.class);
		
		EmployeeDao employeeDao = context.getBean("employeeDao",EmployeeDao.class);
		
		Employee e = new Employee();
		
		e.setName("amit");
		e.setSalary(99500);
		e.setRole("java developer");
		
		
		
	}
}
