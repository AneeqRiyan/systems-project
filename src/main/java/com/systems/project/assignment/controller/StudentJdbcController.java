package com.systems.project.assignment.controller;


import com.systems.project.assignment.Dto.StudentDto;
import com.systems.project.assignment.service.StudentJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentJdbcController {

    @Autowired
    StudentJdbcService jdbcService;

    @GetMapping(path = "/jdbc")
    public List<StudentDto> getAllStudents(){
        return jdbcService.getAllStudents();
    }

    @GetMapping(path = "/jdbc/{id}")
    public StudentDto getStudents(@PathVariable int id){
        return jdbcService.getStudent(id);
    }

    @PostMapping(path = "/jdbc")
    public void creatStudents(@RequestBody StudentDto stu){
        jdbcService.insertStudent(stu);
    }
}
