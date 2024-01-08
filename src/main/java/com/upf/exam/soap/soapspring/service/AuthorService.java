package com.upf.exam.soap.soapspring.service;


import com.upf.exam.soap.soapspring.entite.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAutors();

    Optional<Author> getAutorById(Long id);

    Author saveAutor(Author autor);

    Author updateAutor(Long id, Author autor);

    void deleteAutor(Long id);
}
