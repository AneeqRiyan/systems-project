package com.systems.project.assignment.controller;

import com.systems.project.assignment.Dto.BookIssuedDto;
import com.systems.project.assignment.Dto.StudentDto;
import com.systems.project.assignment.Facade.StudentFacade;
import com.systems.project.assignment.model.Students;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class StudentController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StudentFacade studentFacade;

    //get ALL
    @GetMapping(path = "/students")
    public List<StudentDto> getAllStudents(){
        return modelMapper.map(studentFacade.GetAllStudents(),new TypeToken<List<StudentDto>>(){}.getType());
    }

    //get single
    @GetMapping(path = "/students/{id}")
    public StudentDto getStudent(@PathVariable int id) throws Exception {
        return modelMapper.map(studentFacade.GetStudent(id),StudentDto.class);
    }

    //delete single
    @DeleteMapping(path = "/students/{id}")
    public StudentDto deleteStudent(@PathVariable int id) throws Exception {

        return modelMapper.map(studentFacade.DeleteStudent(id),StudentDto.class);
    }

    //save single
    @PostMapping(path = "/students")
    public Students createNewStudent(@Valid @RequestBody StudentDto students){

        Students stu = modelMapper.map(students,Students.class);
        return studentFacade.CreateStudent(stu);

    }

    //update Student profile
    @PutMapping(path = "/students/{id}")
    public Students UpdateStudent(@PathVariable int id,@Valid @RequestBody StudentDto student) throws Exception {

        Students stu = modelMapper.map(student,Students.class);
        return studentFacade.UpdateStudent(id, stu);
    }
}
