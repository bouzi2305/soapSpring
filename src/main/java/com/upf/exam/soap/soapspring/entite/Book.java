package com.upf.exam.soap.soapspring.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    @Id
    private long id;
    @NonNull
    private String title;
    @NonNull
    private String isbn;
    @ManyToOne
    private Author author;
}
