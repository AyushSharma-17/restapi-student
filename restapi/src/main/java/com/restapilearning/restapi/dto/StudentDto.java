package com.restapilearning.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class StudentDto {
    private long id;
    private String name;
    private String email;
}
