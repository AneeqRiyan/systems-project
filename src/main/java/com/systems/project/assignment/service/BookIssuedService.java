package com.systems.project.assignment.service;

import com.systems.project.assignment.model.BookIssued;
import com.systems.project.assignment.model.Students;
import com.systems.project.assignment.repo.BookIssuedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookIssuedService {

    @Autowired
    BookIssuedRepo issuedRepo;

    //return all
    public List<BookIssued> findAll(){
        return issuedRepo.findAll();
    }

    //return single
    public Optional<BookIssued> findById(int id) throws Exception{
        Optional<BookIssued> book = issuedRepo.findById(id);
        return book;
    }

    //return saved
    public BookIssued save(BookIssued book){
        return issuedRepo.save(book);
    }

    //check issued status
    public boolean check(int sid, int bid){
        return issuedRepo.checkReturnStat(sid, bid);
    }

    //return book
    public Optional<BookIssued> returnBook(int sid,int bid){return Optional.ofNullable(issuedRepo.getReturnedBook(sid, bid));}

    //Schedule check for update late return
    @Scheduled(cron = "0 41 19 * * *")
    private void markLate(){
        issuedRepo.markLate();

    }
}
