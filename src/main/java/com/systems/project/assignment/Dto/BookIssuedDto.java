package com.systems.project.assignment.Dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BookIssuedDto {

    private int BookIssueId;
    private LocalDate IssueDate;
    private LocalDate ReturnDate;
    private boolean IsReturned;
    private boolean IsLate;
    private int BookCatalogId;
    private int StudentId;
}
