package com.systems.project.assignment.Dto;

import com.systems.project.assignment.validation.RollNo;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class StudentDto {

    @NotNull
    private int StudentId;
    @RollNo @NotBlank
    private String RollNo;
    @NotBlank
    private String FirstName;
    @NotBlank
    private String LastName;
    private boolean ActiveStatus;
}
