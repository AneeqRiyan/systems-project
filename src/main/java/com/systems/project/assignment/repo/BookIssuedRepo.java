package com.systems.project.assignment.repo;

import com.systems.project.assignment.model.BookIssued;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookIssuedRepo extends JpaRepository<BookIssued,Integer> {


    @Query(value="Select * from libdb.book_issued where student_id = :stuid and book_catalog_id = :bookid and is_returned = 0", nativeQuery=true)
    BookIssued getReturnedBook(int stuid, int bookid);


    @Query(value="Select is_returned from libdb.book_issued where student_id = :stuid and book_catalog_id = :bookid", nativeQuery=true)
    boolean checkReturnStat(int stuid, int bookid);


    @Modifying
    @Transactional
    @Query(value ="Update libdb.book_issued set is_late = 1 where is_returned = 0 and datediff(SysDate(), issue_date) >= 30",nativeQuery = true)
    void markLate();
}
