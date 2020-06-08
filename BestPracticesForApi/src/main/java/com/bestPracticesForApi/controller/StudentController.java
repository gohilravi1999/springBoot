package com.bestPracticesForApi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

	@PostMapping("/student")
	public String addStudent(String name) {
		return "new student is added";
	}
	
	@GetMapping("/student")
	public String getAllStudent() {
		return "Get all Student";
	}
	
	@GetMapping("/student/{studentId}")
	public String getStudentById(@PathVariable("studentId") long id) {
		return "Get Student By "+id;
	}
	
	@PutMapping("/student")
	public String updateAllStudent() {
		return "Update All Student";
	}
	
	@PutMapping("/student/{studentId}")
	public String updateStudentById(@PathVariable("studentId") long id) {
		return "update Student by "+id;
	}
	
	@DeleteMapping("/student")
	public String deleteStudent() {
		return "delete all student";
	}
	
	@DeleteMapping("/student/{studentId}")
	public String deleteStudentById(@PathVariable("studentId") long id) {
		return "delete student by "+id;
	}
	
	@RequestMapping(value = {"/student"}, method = RequestMethod.GET, params = {"id","status"})
	public String getStudentUsingFilter(@RequestParam(value = "id") long id,
											@RequestParam(value = "status") String status) {
		return "filter student with "+id+" and "+status;
	}
}
