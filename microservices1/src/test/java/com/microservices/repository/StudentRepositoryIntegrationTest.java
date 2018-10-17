package com.microservices.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservices.domain.Student;
import com.microservices.repository.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
//@ContextConfiguration(classes= {MicroservicesApplication.class})
public class StudentRepositoryIntegrationTest {

	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void test() {
	//	fail("Not yet implemented");
	}

	
	@Test
	public void whenFindByName_thenReturnStudent() {		
		// given Student		
		Student student = new Student("ABC","XYZ");
		entityManager.persist(student);
		entityManager.flush();		
		Student foundStudent = studentRepository.findByFirstName(student.getFirstName());		
		assertThat(foundStudent.getFirstName()).isEqualTo(student.getFirstName());
	}

}
