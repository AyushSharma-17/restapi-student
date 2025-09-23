package com.restapilearning.restapi.Services;

import java.util.List;

import com.restapilearning.restapi.dto.StudentDto;

public interface StudentService {
    List<StudentDto> getAllStudent();

    StudentDto getStudentById(long id);

}
