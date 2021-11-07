package com.systems.project.assignment.repo;

import com.systems.project.assignment.model.BookCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookCatalogRepo extends JpaRepository<BookCatalog,Integer> {

//    Optional<BookCatalog> findBookCatalogByBookName(String userName);

}