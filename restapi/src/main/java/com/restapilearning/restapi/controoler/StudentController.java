package com.restapilearning.restapi.controoler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapilearning.restapi.Repository.StudentRepository;
import com.restapilearning.restapi.Services.StudentService;
import com.restapilearning.restapi.dto.AddStudentRequestDto;
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

    

    @GetMapping("/students")
    public List <Student> getStudents() {
        return studentRepository.findAll();
    }

    //getting student by using id
    @GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    //post mapping for creating student
    @PostMapping("/students")
    public ResponseEntity <StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));  
    }
    //delete mapping for deleting student
    @DeleteMapping("/students/{id}")
    public ResponseEntity <Void> deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
        //return ResponseEntity.noContent().build();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
