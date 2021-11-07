package com.systems.project.assignment.Facade;

import com.systems.project.assignment.Dto.BookIssuedDto;
import com.systems.project.assignment.model.BookCatalog;
import com.systems.project.assignment.model.BookIssued;
import com.systems.project.assignment.service.BookIssuedService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookIssuedFacade {

    @Autowired
    BookIssuedService issuedService;

    @Autowired
    StudentFacade studentFacade;
    @Autowired
    BookCatalogFacade catalogFacade;

    @Autowired
    ModelMapper modelMapper;

    public List<BookIssued> GetIssuedList(){
        return issuedService.findAll();
    }

    //issue a book
    public BookIssuedDto issueBook(int stuId, int bookId) throws Exception {
//        if ((studentFacade.GetStudent(stuId) == null) && (catalogFacade.GetBook(bookId) == null)) {
//            throw new Exception("no match found");
//        }

        if ( issuedService.returnBook(stuId, bookId).isPresent()) {

            throw new Exception("book already issued");
        }
        BookCatalog bookCatalog = catalogFacade.GetBook(bookId).get();
//        bookCatalog.setAvailableCopies((bookCatalog.getAvailableCopies()-1));

            BookIssued bookIssued = new BookIssued(bookCatalog,studentFacade.GetStudent(stuId));
            //subtracting an available book copy
        bookIssued.getBookCatalog().setAvailableCopies(bookCatalog.getAvailableCopies()-1);

        return modelMapper.map(issuedService.save(bookIssued), BookIssuedDto.class);
    }

    //return a book
    public BookIssued returnBook(int stuId, int bookId) throws Exception {
        BookIssued bookIssued = null;
        if (issuedService.check(stuId, bookId) ==  true) {
            throw new Exception("book already issued");
        }
        bookIssued = issuedService.returnBook(stuId,bookId).get();
        bookIssued.setIsReturned(true);
        bookIssued.setReturnDate(LocalDate.now());
        return issuedService.save(bookIssued);
    }

//    public BookIssued checkIssued(int stuId,int bookId){
//        return issuedService.check(stuId,bookId);
//    }



}
