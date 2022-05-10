package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(path = "/students", method = RequestMethod.GET)
	public List<Student> getAllStudents(){
		return studentService.getAllStudent();
	}
	
	@RequestMapping(path = "/students", method = RequestMethod.POST)
	public int addStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	
}
