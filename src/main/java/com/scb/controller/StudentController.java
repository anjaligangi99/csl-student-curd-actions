package com.scb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.entity.Student;
import com.scb.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Student student){
		return new ResponseEntity<String>(studentService.create(student),HttpStatus.CREATED);
		
	}
	@PostMapping("/update")
	public ResponseEntity<String> update(@RequestBody Student student){
		return new ResponseEntity<String>(studentService.update(student),HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam Integer id){
		return new ResponseEntity<String>(studentService.delete(id),HttpStatus.OK);
	}
	
	@GetMapping("/searchById")
	public ResponseEntity<Student> findStudentById(@RequestParam Integer id){
		return new ResponseEntity<Student>(studentService.findStudentById(id),HttpStatus.OK);
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Student>> findAll(@RequestParam String stream){
	   return new ResponseEntity<List<Student>>(studentService.findAll(stream),HttpStatus.OK);	
	}

}
