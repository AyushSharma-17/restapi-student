package com.restapilearning.restapi.controoler;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restapilearning.restapi.Repository.StudentRepository;
import com.restapilearning.restapi.Services.StudentService;
import com.restapilearning.restapi.dto.StudentDto;
import com.restapilearning.restapi.entity.Student;

import lombok.RequiredArgsConstructor;






@RestController
@RequiredArgsConstructor
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent() {
        return new StudentDto(1, "John Doe", "john@gmail.com");
    }

     private final StudentRepository studentRepository;
     private final StudentService studentService;

    

    @GetMapping("/studentall")
    public List <Student> getStudents() {
        return studentRepository.findAll();
    }

    //getting student by using id
    @GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }
    
}
