package com.restapilearning.restapi.controoler;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapilearning.restapi.Repository.StudentRepository;
import com.restapilearning.restapi.dto.StudentDto;
import com.restapilearning.restapi.entity.student;





@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent() {
        return new StudentDto(1, "John Doe", "john@gmail.com");
    }

     private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/studentall")
    public List <student> getStudents() {
        return studentRepository.findAll();
    }

    
}
