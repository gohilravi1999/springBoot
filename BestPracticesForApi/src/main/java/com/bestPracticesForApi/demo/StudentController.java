package com.bestPracticesForApi.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class StudentController {

	@PostMapping("/student")
	public String addStudent() {
		return "new student is added";
	}
	
	@GetMapping("/student")
	public String getAllStudent() {
		return "Get all Student";
	}
	
	@GetMapping("/student/{studentId}")
	public String getStudentById() {
		return "Get Student By ID";
	}
	
	@PutMapping("/student")
	public String updateAllStudent() {
		return "Update All Student";
	}
	
	@PutMapping("/student/{studentId}")
	public String updateStudentById() {
		return "update Student by id";
	}
	
	@DeleteMapping("/student")
	public String deleteStudent() {
		return "delete all student";
	}
	
	@DeleteMapping("/student/{studentId}")
	public String deleteStudentById() {
		return "delete student by id";
	}
	
	@GetMapping("/student")
	public String getStudentUsingFilter(@RequestParam(value = "id") long id,
											@RequestParam(value = "status") String status) {
		return "filter student with"+id+"and"+status;
	}
}
