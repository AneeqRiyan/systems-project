package com.systems.project.assignment.controller;

import com.systems.project.assignment.Dto.BookIssuedDto;
import com.systems.project.assignment.Facade.BookIssuedFacade;
import com.systems.project.assignment.repo.BookIssuedRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
public class BookIssuedController {

    @Autowired
    BookIssuedFacade issuedFacade;
    @Autowired
    ModelMapper modelMapper;

    //Controller to view Issued book status
    @GetMapping(path = "/booksissued")
    public List<BookIssuedDto> GetIssuedBooks(){
        return modelMapper.map(issuedFacade.GetIssuedList(),new TypeToken<List<BookIssuedDto>>(){}.getType());
    }

//    controller to issue book
    @PostMapping(path = "/issue")
    public BookIssuedDto IssueBook(@RequestParam(name = "sid") int studentId,@RequestParam(name = "bid")int bookid)  throws Exception {
        BookIssuedDto issuedDto =modelMapper.map(issuedFacade.issueBook(studentId,bookid),BookIssuedDto.class);
        return issuedDto;
//        @RequestParam(name = "stid") int studentId,@RequestParam(name = "bkid") int bookId) or @Param("studentId") int studentid,
    }

    //controller to return book
    @PutMapping(path = "/return")
    public BookIssuedDto Return(@RequestParam(name = "sid") int studentId,@RequestParam(name = "bid") int bookId) throws Exception {
        BookIssuedDto issuedDto =modelMapper.map(issuedFacade.returnBook(studentId,bookId),BookIssuedDto.class);

        return issuedDto;
    }


    @GetMapping(path = "/late")
    public List<BookIssuedDto> filterIssued(){

        List<BookIssuedDto> bookDto = modelMapper.map(issuedFacade.GetIssuedList(),new TypeToken<List<BookIssuedDto>>(){}.getType());
        List<BookIssuedDto> filterDto = bookDto.stream().filter(c -> c.isIsLate() == true)
                .collect(Collectors.toList());

        return filterDto;
    }

    @GetMapping(path = "/past")
    public List<BookIssuedDto> filterIssuedBooks(@RequestParam(name = "days") int id){

        List<BookIssuedDto> bookDto = modelMapper.map(issuedFacade.GetIssuedList(),new TypeToken<List<BookIssuedDto>>(){}.getType());
        List<BookIssuedDto> filterDto = bookDto.stream().filter(c -> ChronoUnit.DAYS.between(LocalDate.now(),c.getIssueDate()) <= id)
                .collect(Collectors.toList());

        return filterDto;
    }
}
