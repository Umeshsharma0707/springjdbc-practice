package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentInterface {
	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int id);
	public Student getStudent(int rollNo);
	public List<Student> getAllStudents();
}
