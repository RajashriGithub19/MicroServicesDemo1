package com.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.domain.Student;
import com.microservices.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student findStudentByName(String firstName) {

		return studentRepository.findByFirstName(firstName);
	}

	@Override
	public Student findById(String studentId) {
		Optional<Student> s = studentRepository.findById(Integer.parseInt(studentId));

		if (s != null && s.isPresent()) {
			return s.get();
		}
		
		else
			return null;
	}

	@Override
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}
}
