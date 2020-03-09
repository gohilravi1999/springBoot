package com.crudOperation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudOperation.Student;
import com.crudOperation.StudentRepository;

@Service
@Transactional
public class StudentServices
{
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> listAll() {
        return studentRepository.findAll();
    }
	
	 public void save(Student student) 
	 {
		 studentRepository.save(student);
	 }
	     
	 public Student get(int id) 
	 {
	        return studentRepository.findById(id).get();
	 }
	 
	 public void delete(int id) 
	 {
		  studentRepository.deleteById(id);
	 }
}
