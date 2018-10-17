package com.microservices.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.domain.Student;
import com.microservices.service.StudentService;

@Component
@RestController
@RequestMapping(value = "/student")
public class StudentEndpoint {

	@Autowired
	StudentService studentService;

	@GetMapping("/{studentId}")
	public ResponseEntity<String> getStudent(@PathVariable String studentId) {

		// Optional<Student> s =
		// studentRepository.findById(Integer.parseInt(studentId));

		Student s = studentService.findById(studentId);

		if (s != null)
			return new ResponseEntity<String>(s.toString(), HttpStatus.OK);

		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents() {

		List<Student> students = studentService.findAllStudents();

		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
}
