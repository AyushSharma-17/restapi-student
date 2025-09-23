package com.restapilearning.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapilearning.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
