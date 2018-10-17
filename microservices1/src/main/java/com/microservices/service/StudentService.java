package com.microservices.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.microservices.domain.Student;

public interface StudentService {
	public Student findStudentByName(String name);
	public Student findById(String id);
	public List<Student> findAllStudents();
}
