package com.microservices.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.domain.Subject;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
