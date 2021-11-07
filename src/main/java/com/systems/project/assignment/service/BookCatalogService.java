package com.systems.project.assignment.service;

import com.systems.project.assignment.model.BookCatalog;
import com.systems.project.assignment.repo.BookCatalogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCatalogService {

    @Autowired
    BookCatalogRepo catalogRepo;


    //get all Books
    public List<BookCatalog> findAll(){
        return catalogRepo.findAll();
    }

    //get book by id
    public Optional<BookCatalog> findById(int id) throws Exception{
        return catalogRepo.findById(id);
    }

    //get book by name
//    public Optional<BookCatalog> findByName(String name) throws Exception{
//        Optional<BookCatalog> book = catalogRepo.findBookCatalogByBookName(name);
//        return book;
//    }

    public BookCatalog save(BookCatalog book){
        return catalogRepo.save(book);
    }

}
