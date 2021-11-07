package com.systems.project.assignment.service;

import com.systems.project.assignment.model.Students;
import com.systems.project.assignment.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    StudentRepo studentRepo;

//get all Students
    public List<Students> findAll(){
        return studentRepo.findAll();
    }

//get by id
    public Optional<Students> findById(int id) throws Exception{
        Optional<Students> students = studentRepo.findById(id);
        return students;
    }

    //save
    public Students save(Students stu) {
        return studentRepo.save(stu);
    }


}