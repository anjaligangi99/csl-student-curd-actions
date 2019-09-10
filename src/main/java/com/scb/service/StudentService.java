package com.scb.service;

import java.util.List;

import com.scb.entity.Student;

public interface StudentService {
	
	public String create(Student student);
	
	public String update(Student student);
	
	public String delete(Integer id);
	
	public Student findStudentById(Integer id);
	
	public List<Student> findAll(String stream);

}
