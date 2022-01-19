package com.neosoft.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Student;
import com.neosoft.myexception.ResourceNotFoundException;
import com.neosoft.repository.ProjectRepository;
import com.neosoft.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping("/student")
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	@PostMapping("/project/{projectId}/student")
	public Student createStudent(@Valid @RequestBody Student student, @PathVariable Long projectId) {
		return projectRepository.findById(projectId).map(project -> {
			student.setProject(project);
			return studentRepository.save(student);
		}).orElseThrow(() -> new ResourceNotFoundException("Project", "ProjectID", projectId));
	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudentById(@PathVariable Long studentId) {
		return studentRepository.findById(studentId).get();
	}
}
