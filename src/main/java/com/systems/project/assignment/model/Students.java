package com.systems.project.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity
public class Students {


    @Id @GeneratedValue
    private int StudentId;
    private String RollNo;
    private String FirstName;
    private String LastName;
    private boolean ActiveStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "students")
    private List<BookIssued> bookIssued;
}
