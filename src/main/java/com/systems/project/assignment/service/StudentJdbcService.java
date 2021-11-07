package com.systems.project.assignment.service;

import com.systems.project.assignment.Dto.StudentDto;
import com.systems.project.assignment.repo.StudentJdbcRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentJdbcService {

    @Autowired
    StudentJdbcRepo jdbcRepo;


    public List<StudentDto> getAllStudents() {
        List<StudentDto> stu = jdbcRepo.getAllStudents();
        return stu;
    }

    public StudentDto getStudent(int id){
        return jdbcRepo.getEmployeeById(id);
    }

    public void insertStudent(StudentDto studentDto){
        jdbcRepo.insertStudent(studentDto);
    }
}
