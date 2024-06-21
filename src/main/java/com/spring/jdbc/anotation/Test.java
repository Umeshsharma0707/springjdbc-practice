package com.spring.jdbc.anotation;


import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.anotation.dao.EmployeeDao;
import com.spring.jdbc.anotation.entities.Employee;



public class Test {
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(com.spring.jdbc.anotation.JavaConfig.class);
		
		
	
		  EmployeeDao employeeDao = context.getBean("employeeDao",EmployeeDao.class);
		 /* 
		 * 
		 * List<Employee> allEmployees = employeeDao.getAllEmployees();
		 * 
		 * for(Employee employee : allEmployees) { System.out.println(employee); }
		 */
		 
		
		
		
		Employee employee = employeeDao.getEmployee(5);
		System.out.println(employee);
		
		
		
		
		
		/*
		 * int deleteEmployee = employeeDao.deleteEmployee(7);
		 * System.out.println("total row deleted : " + deleteEmployee);
		 */
		
		
		/* Employee employee = new Employee();
		employee.setId(13);
		employee.setName("rahul");
		employee.setSalary(87500);
		employee.setRole("mern dev");
		int updateEmployee = employeeDao.updateEmployee(employee);
		System.out.println("total row updated : " + updateEmployee);
		
		*/
	}
	public static void insertEmployeeApp() {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(com.spring.jdbc.anotation.JavaConfig.class);
		
		EmployeeDao employeeDao = context.getBean("employeeDao",EmployeeDao.class);
		boolean flag = true;
		while(flag == true) {
		
		Scanner sc = new Scanner(System.in);
	
			Employee employee = new Employee();
			System.out.println("enter name");
			employee.setName(sc.next());
			System.out.println("enter salary");
			employee.setSalary(sc.nextDouble());
			System.out.println("enter role");
			employee.setRole(sc.next());
			
			int insertEmployee = employeeDao.insertEmployee(employee);
			System.out.println("inserted employee : " + insertEmployee);
			
			System.out.println("are you want to add another employee \n enter ['y' / 'N'] ");
			char ans = sc.next().charAt(0);
			
			if(ans == 'y' || ans == 'Y') {
				flag = true;
			}else if(ans == 'n' || ans == 'N'){
				flag = false;
				System.out.println("ok ");
			}else {
				flag = false;
			}
		
	
		
		}
	}
}
