package com.neosoft.poc.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.poc.model.Student;
import com.neosoft.poc.repository.ProjectRepository;
import com.neosoft.poc.repository.StudentRepository;
import com.neosoft.poc.service.StudentService;
import com.neosoft.spring.boot.myexception.ResourceNotFoundException;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
   @Autowired
   private StudentRepository studentReposiotry;
   
   @Autowired
   private ProjectRepository projectRepository;
   
   @GetMapping("/students")
	public List<Student> getAllStudents(){
		
		return studentReposiotry.findAll();
	}
	
	@GetMapping("/projects/{projectId}/student")
	public List<Student> getAllstudentsByPostId(@PathVariable int projectId){
		return studentReposiotry.findByProjectId(projectId);
	}
	
	@GetMapping("/students/{id}")
	public Optional<Student> getStudentById(@PathVariable int id) {
		return studentReposiotry.findById(id);
	}
	
	
	@GetMapping("/projects/{projectId}/students/{id}")
	public Student getStudentByIdAndPostId(@PathVariable int projectId, @PathVariable int id) {
		return studentReposiotry.findByIdAndProjectId(projectId, id);
		
	}
	
	
	@PostMapping("/projects/{projectId}/students")
	public Student AddStudent(@PathVariable int projectId,@Validated @RequestBody Student student) {
		
		return projectRepository.findById(projectId).map(project -> {
			student.setProject(project);
			return studentReposiotry.save(student);
		}).orElseThrow(() -> new ResourceNotFoundException("project", "projectId", projectId));
		
	}

}
