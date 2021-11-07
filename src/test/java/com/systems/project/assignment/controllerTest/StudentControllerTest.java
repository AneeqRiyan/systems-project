package com.systems.project.assignment.controllerTest;

import com.systems.project.assignment.Dto.StudentDto;
import com.systems.project.assignment.Facade.StudentFacade;
import com.systems.project.assignment.controller.StudentController;
import com.systems.project.assignment.model.Students;
import com.systems.project.assignment.service.StudentsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentFacade studentFacade;

    @MockBean
    StudentsService studentsService;

//    @Test
//    public void  getStudent() throws Exception{
//        given(studentsService.findById(Mockito.anyInt())).willReturn(new StudentDto(1,"",));
//        mockMvc.perform(MockMvcRequestBuilders.get("/students/1"))
//                .andExpect(status().isOk());
//
//    }
}
