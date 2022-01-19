package com.neosoft.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.poc.model.Student;
import com.neosoft.poc.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	/*
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
		
	}
	
	public Optional<Student> getStudent(int id) {
		return studentRepository.findById(id);
	}
	
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	

	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}
*/

}
