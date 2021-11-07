package com.systems.project.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookIssued {

    @Id @GeneratedValue
    private int BookIssueId;
    private LocalDate IssueDate = LocalDate.now();
    private LocalDate ReturnDate;
    private boolean IsReturned = false;
    private boolean IsLate = false;

    public BookIssued(BookCatalog bookCatalog, Students students) {
        this.bookCatalog = bookCatalog;
        this.students = students;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BookCatalogId", referencedColumnName = "BookCatalogId")
    private BookCatalog bookCatalog;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StudentId", referencedColumnName = "StudentId")
    private Students students;
}
