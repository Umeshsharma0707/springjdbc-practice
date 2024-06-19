package com.spring.jdbc.anotation.dao;

import java.util.List;

import com.spring.jdbc.anotation.entities.Employee;

public interface EmployeeInterface {
		public int insertEmployee(Employee employee);
		public int updateEmployee(Employee employee);
		public int deleteEmployee(int id);
		public Employee getEmployee(int id);
		public List<Employee> getAllEmployees();
}
