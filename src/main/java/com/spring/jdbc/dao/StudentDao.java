package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDao implements StudentInterface {

	JdbcTemplate jdbcTemplate = new JdbcTemplate();

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertStudent(Student student) {
		String sql = "insert into student (name,studentRoll,grade,schoolName) values (?,?,?,?)";

		int result = this.jdbcTemplate.update(sql, student.getName(), student.getStudentRoll(), student.getGrade(),
				student.getSchoolName());

		return result;
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "update student set name = ?,studentRoll=?,grade=?,schoolName=? where id = ?";

		int result = this.jdbcTemplate.update(sql, student.getName(), student.getStudentRoll(), student.getGrade(),
				student.getSchoolName(), student.getId());
		return result;
	}

	@Override
	public int deleteStudent(int id) {
		String sql = "delete from student where id = ?";
		int result = this.jdbcTemplate.update(sql,id);
		return result;
	}

	@Override
	public Student getStudent(int rollNo) {
		String sql = "select * from student where studentRoll = ?";
		RowMapper<Student> rowMapper = new StudentRowMapper();
		Student student = this.jdbcTemplate.queryForObject(sql,rowMapper,rollNo);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		String sql = "select * from student";
		RowMapper<Student> rowMapper = new StudentRowMapper();
		List<Student> students = this.jdbcTemplate.query(sql, rowMapper);
		
		return students;
	}

}
