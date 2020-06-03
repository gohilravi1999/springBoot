package com.bestPracticesForApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bestPracticesForApi.model.MessageResponse;
import com.bestPracticesForApi.model.Student;
import com.bestPracticesForApi.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public ResponseEntity<?> addStudent(Student student){
		
		studentRepository.save(student);
		return ResponseEntity.ok(new MessageResponse("Student is added successfully!"));
		
	}
	
	public List<Student> getAllStudentInfo(){
		
		return studentRepository.findAll();
		
	}
	
	
	public Student getStudentInfo(long studentId){
		
		return studentRepository.findById(studentId).get();
		
	}
	
	public ResponseEntity<?> updateStudent(long studentId,Student student){
		
		Optional<Student> studentDetails = studentRepository.findById(studentId);
		Student studentData = studentDetails.get();
		
		studentData.setName(student.getName());
		studentData.setMarks(student.getMarks());
		studentRepository.save(studentData);
		return ResponseEntity.ok(new MessageResponse("Student is updated successfully!"));
	}
	
	public ResponseEntity<?> deleteStudent(long studentId){
		
		studentRepository.deleteById(studentId);
		return ResponseEntity.ok(new MessageResponse("Student is deleted successfully!"));
		
	}
	
}
