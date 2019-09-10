package com.scb.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.scb.entity.Student;
import com.scb.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public String create(Student student) {
		if (student != null) {
			Student student2 = studentRepository.save(student);
			if (student2 != null)
				return "Student Details Saved Successfully.";
			return "Please try again later.";

		}
		return null;

	}

	@Override
	public String update(Student student) {
		if (student != null) {
		Student  student2 = studentRepository.findById(student.getId()).get();
			if (student2!=null) {
				student2.setName(student.getName());
				student2.setStream(student.getStream());
				if(studentRepository.save(student2)!=null)
					return "Student details updated Successfully.";
				return "Please try again later.";
			}	
		}
		return null;
	}

	@Override
	public String delete(Integer id) {
		
	      if (id != null) {
		  	studentRepository.deleteById(id);
		  	return "Student deleted Successfully";
		}
		return null;
	}

	@Override
	public Student findStudentById(Integer id) {
		if (id != null) {
			 return studentRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public List<Student> findAll(String stream) {
		if (!StringUtils.isEmpty(stream)) 
		return studentRepository.findByStream(stream);
		return null;
	}
	
	

}
