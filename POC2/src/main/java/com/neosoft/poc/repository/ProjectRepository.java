package com.neosoft.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.poc.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
