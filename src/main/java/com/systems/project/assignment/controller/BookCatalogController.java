package com.systems.project.assignment.controller;

import com.systems.project.assignment.Dto.BookCatalogDto;
import com.systems.project.assignment.Facade.BookCatalogFacade;
import com.systems.project.assignment.model.BookCatalog;
import com.systems.project.assignment.repo.BookCatalogRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class BookCatalogController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BookCatalogFacade catalogFacade;


    @GetMapping(path = "/books")
    public List<BookCatalog> getAllBooks(){
        return catalogFacade.GettAllBooks();

    }

    @GetMapping(path = "/books/{id}")
    public Optional<BookCatalog> getBooks(@PathVariable int id) throws Exception {

        return catalogFacade.GetBook(id);
    }

//    @DeleteMapping(path = "/books/{id}")
//    public String deleteStudent(@PathVariable int id){
//        return id+" book Deleted";
//    }

    @PostMapping(path = "/books")
    public BookCatalog AddNewBook(@RequestBody BookCatalogDto book){
        BookCatalog books = modelMapper.map(book,BookCatalog.class);
        return catalogFacade.AddBooks(books);

    }

    @PutMapping(path = "/books/{id}")
    public BookCatalog UpdateStudent(@PathVariable int id, @RequestBody BookCatalogDto book) throws Exception {
        BookCatalog books = modelMapper.map(book,BookCatalog.class);
        return catalogFacade.UpdateBook(id,books);
    }


}
