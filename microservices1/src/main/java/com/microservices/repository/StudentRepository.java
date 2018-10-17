package com.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.domain.Student;

@Repository
@Transactional

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public Student findByFirstName(String firstName);
}
