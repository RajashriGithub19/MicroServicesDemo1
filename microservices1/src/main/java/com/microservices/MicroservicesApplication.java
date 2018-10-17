package com.microservices;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microservices.domain.Student;
import com.microservices.domain.Subject;
import com.microservices.repository.StudentRepository;
import com.microservices.repository.SubjectRepository;

@SpringBootApplication
public class MicroservicesApplication {//implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	SubjectRepository subjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}

//	@Transactional
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//
//		Student jack = new Student("Jack", "Peterson");
//		Student peter = new Student("Peter", "Hamilton");
//
//		Subject math = new Subject("Mathematics");
//		Subject computer = new Subject("Computer");
//
//		Set<Subject> subjects = new HashSet<Subject>();
//		subjects.add(math);
//		subjects.add(computer);
//
//		jack.setSubjects(subjects);
//		peter.setSubjects(subjects);
//
//		studentRepository.save(jack);
//		studentRepository.save(peter);
//
//		Set<Student> students = new HashSet<Student>();
//		students.add(jack);
//		students.add(peter);
//
//		math.setStudents(students);
//		computer.setStudents(students);
//
//		subjectRepository.save(math);
//		subjectRepository.save(computer);
//
//		List<Student> studentLst = studentRepository.findAll();
//		List<Subject> subLst = subjectRepository.findAll();
//
//		System.out.println(studentLst.size());
//		System.out.println(subLst.size());
//
//		System.out.println("===================Students info:==================");
//		studentLst.forEach(student -> System.out.println(student.toString()));
//
//		System.out.println("===================Students info:==================");
//		subLst.forEach(subject -> System.out.println(subject.toString()));
//	}

}
