package com.systems.project.assignment.Facade;

import com.systems.project.assignment.exception.StudentNotFoundException;
import com.systems.project.assignment.model.Students;
import com.systems.project.assignment.repo.StudentRepo;
import com.systems.project.assignment.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentFacade {

    @Autowired
    StudentsService studentsService;
    //get all Students
    public List<Students> GetAllStudents(){
        return studentsService.findAll();
    }

    //get by id
    public Students GetStudent(int id) throws Exception{
        Optional<Students> students = studentsService.findById(id);
        if(!students.isPresent()){
            throw new StudentNotFoundException("student does not exist");
        }
        return students.get();
    }

    //delete student
    public Students DeleteStudent(int id) throws Exception {
        Students student = null;
        Optional<Students> students = studentsService.findById(id);
        if (!students.isPresent()) {
            throw new StudentNotFoundException("student does not exist");
        }
        student = students.get();
        student.setActiveStatus(false);
        studentsService.save(student);
        return student;
    }

    //create new student
    public Students CreateStudent(Students stu) {
        return studentsService.save(stu);
    }

    //update student profile
    public Students UpdateStudent(int id, Students students) throws Exception{
        Students stu = null;
        Optional<Students> student = studentsService.findById(id);
        if(!student.isPresent()){
            throw new StudentNotFoundException("Student Not Found");
        }
        stu = student.get();
        stu.setFirstName(students.getFirstName());
        stu.setLastName(students.getLastName());
        return studentsService.save(stu);
    }
}
