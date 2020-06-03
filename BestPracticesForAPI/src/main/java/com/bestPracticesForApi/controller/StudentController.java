package com.bestPracticesForApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestPracticesForApi.model.Student;
import com.bestPracticesForApi.services.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudentInfo() {
		
		return studentService.getAllStudentInfo();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentInfo(@PathVariable("studentId") long studentId) {
		
		return studentService.getStudentInfo(studentId);
	}
	
	@PostMapping("/students")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		
		return studentService.addStudent(student);
		
	}
	
	@PutMapping("/students/{studentId}")
	public ResponseEntity<?> updateStudent(@PathVariable("studentId") long id ,@RequestBody Student student) {
		
		return studentService.updateStudent(id,student);
		
	}
	
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable("studentId") long id) {
		
		return studentService.deleteStudent(id);
		
	}
}
