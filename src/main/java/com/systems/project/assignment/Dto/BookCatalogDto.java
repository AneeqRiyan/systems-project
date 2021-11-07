package com.systems.project.assignment.Dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
public class BookCatalogDto {

    @NotBlank
    private int BookCatalogId;
    @NotBlank
    private long Code;
    @NotBlank
    private String Author;
    @NotBlank
    private String BookName;
    @NotBlank
    @Max(3)
    private int totalCopies;
    @NotBlank
    private int AvailableCopies;
}
