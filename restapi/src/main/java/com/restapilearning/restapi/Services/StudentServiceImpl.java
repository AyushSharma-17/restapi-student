package com.restapilearning.restapi.Services;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.restapilearning.restapi.Repository.StudentRepository;
import com.restapilearning.restapi.dto.StudentDto;
import com.restapilearning.restapi.entity.Student;

import lombok.RequiredArgsConstructor;





@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

   
    //for getting all student details
    @Override
    public List<StudentDto> getAllStudent() {
         List<Student> students = studentRepository.findAll();
         List<StudentDto> studentDtoList =  students.stream().map( student -> new StudentDto(
            student.getId(),
            student.getName(),
            student.getEmail()
        )).toList();
        return studentDtoList;
    }
    //getting student by id
    @Override
    public StudentDto getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
       StudentDto studentDto = modelMapper.map(student, StudentDto.class);
       return studentDto;
    }
}
