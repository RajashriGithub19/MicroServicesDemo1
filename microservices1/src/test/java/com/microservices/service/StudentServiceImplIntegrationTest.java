package com.microservices.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservices.domain.Student;
import com.microservices.repository.StudentRepository;

@RunWith(SpringRunner.class)
public class StudentServiceImplIntegrationTest {

	@TestConfiguration
	static class StudentServiceImplTestContextConfiguration {

		@Bean
		public StudentService studentService() {
			return new StudentServiceImpl();
		}
	}

	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentRepository studentRepository;

	@Before
	public void setUp() {
		Student student = new Student("John", "hammer");
		Mockito.when(studentRepository.findByFirstName(student.getFirstName())).thenReturn(student);
	}

	@Test
	public void whenValidNameStudentFound() {
		String studentName = "John";
		Student foundStudent = studentService.findStudentByName(studentName);
		assertThat(foundStudent.getFirstName()).isEqualTo(studentName);
	}

}
