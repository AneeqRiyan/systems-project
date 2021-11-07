package com.systems.project.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookCatalog {

    @Id @GeneratedValue
    private int BookCatalogId;
    private long Code;
    private String Author;
    private String BookName;
    private int TotalCopies;
    private int AvailableCopies;

    @JsonIgnore
    @OneToMany(mappedBy = "bookCatalog")
    private List<BookIssued> bookIssued;
}
