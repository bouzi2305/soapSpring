package com.upf.exam.soap.soapspring.controller;

import com.upf.exam.soap.soapspring.entite.Author;
import com.upf.exam.soap.soapspring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService autorService) {
        this.authorService = autorService;
    }

    @GetMapping
    public ResponseEntity<
                List<Author>> getAllAuthors() {
        List<Author> autors = authorService.getAllAutors();
        return new ResponseEntity<>(autors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> autor = authorService.getAutorById(id);
        return autor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author autor) {
        Author savedAutor = authorService.saveAutor(autor);
        return new ResponseEntity<>(savedAutor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author autor) {
        Author updatedAutor = authorService.updateAutor(id, autor);
        return new ResponseEntity<>(updatedAutor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
