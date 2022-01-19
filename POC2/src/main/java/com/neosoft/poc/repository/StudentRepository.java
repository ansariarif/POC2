package com.neosoft.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.poc.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {
	
    List<Student> findByProjectId(int projectId);
	
	Student findByIdAndProjectId(int id, int projectId);

}
