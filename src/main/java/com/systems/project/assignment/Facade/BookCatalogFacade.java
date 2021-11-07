package com.systems.project.assignment.Facade;

import com.systems.project.assignment.exception.BookNotFoundException;
import com.systems.project.assignment.model.BookCatalog;
import com.systems.project.assignment.repo.BookCatalogRepo;
import com.systems.project.assignment.service.BookCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCatalogFacade {

    @Autowired
    BookCatalogRepo catalogRepo;

    @Autowired
    BookCatalogService catalogService;

//get all Books
    public List<BookCatalog> GettAllBooks(){
        return catalogService.findAll();
    }

// get single book
    public Optional<BookCatalog> GetBook(int id) throws Exception{
        Optional<BookCatalog> book = catalogService.findById(id);
        if (!book.isPresent())
        {
            throw new BookNotFoundException("No book by this name");
        }

        return book;
    }

    //Delete a book
//    public BookCatalog DeleteBook(int id) throws Exception {
//        BookCatalog book = null;
//        Optional<BookCatalog> books = catalogRepo.findById(id);
//        if (books.isPresent()) {
//            book = books.get();
//            book.setdeleteStatus(false);
//            catalogRepo.save(book);
//        }
//        return book;
//    }

    public BookCatalog AddBooks(BookCatalog book) {
        return catalogService.save(book);
    }

    public BookCatalog UpdateBook(int id, BookCatalog books) throws Exception{
        BookCatalog book = null;
        Optional<BookCatalog> found = catalogService.findById(id);
        if(!found.isPresent()){
            throw new BookNotFoundException("Not Found");
        }
        book = found.get();
            book.setAuthor(books.getAuthor());
            book.setTotalCopies(books.getTotalCopies());
        return catalogService.save(book);}
}
