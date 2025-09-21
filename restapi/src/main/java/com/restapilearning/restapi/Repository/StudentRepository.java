package com.restapilearning.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapilearning.restapi.entity.student;

public interface StudentRepository extends JpaRepository<student, Long> {
    
}
