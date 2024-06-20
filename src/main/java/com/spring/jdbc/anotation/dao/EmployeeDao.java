package com.spring.jdbc.anotation.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.anotation.entities.Employee;

@Component("employeeDao")
public class EmployeeDao implements EmployeeInterface{
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertEmployee(Employee employee) {
		String sql = "insert into employees (name,salary,role) values (?,?,?)";
		int result = this.jdbcTemplate.update(sql,employee.getName(),employee.getSalary(),employee.getRole());
		return result;
	}

	@Override
	public int updateEmployee(Employee employee) {
		String sql = "update employees set name = ?, salary = ?, role = ? where id = ?";
		int result = this.jdbcTemplate.update(sql,employee.getName(),employee.getSalary(),employee.getRole(),employee.getId());
		return result;
	}

	@Override
	public int deleteEmployee(int id) {
		String sql = "delete from employees where id = ?";
		int result = this.jdbcTemplate.update(sql,id);
		return result;
	}


	@Override
	public Employee getEmployee(int id) {
		String sql = "select * from employees where id = ?";
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		 Employee employee = this.jdbcTemplate.queryForObject(sql, rowMapper,id);
		 return employee;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select * from employees";
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		 List<Employee> employees = this.jdbcTemplate.query(sql, rowMapper);
		 return employees;
	}

}
