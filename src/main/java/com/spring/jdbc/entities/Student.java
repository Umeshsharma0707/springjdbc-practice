package com.spring.jdbc.entities;

public class Student {
	private int id;
	private String name;
	private String studentRoll;
	private String grade;
	private static String schoolName;
	
	// getters setters
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentRoll() {
		return studentRoll;
	}
	public void setStudentRoll(String studentRoll) {
		this.studentRoll = studentRoll;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public static String getSchoolName() {
		return schoolName;
	}
	public static void setSchoolName(String schoolName) {
		Student.schoolName = schoolName;
	}
	@Override
	public String toString() {
		return "Student [ID= " + id + ",name=" + name + ", studentRoll=" + studentRoll + ", grade=" + grade + ", schoolName=" + schoolName + " ]";
	}
	
	
	
	
}
