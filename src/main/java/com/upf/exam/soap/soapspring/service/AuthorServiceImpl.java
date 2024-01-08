package com.upf.exam.soap.soapspring.service;

import com.upf.exam.soap.soapspring.entite.Author;
import com.upf.exam.soap.soapspring.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class AuthorServiceImpl implements AuthorService {

        private final AuthorRepo authorRepository;

        @Autowired
        public AuthorServiceImpl(AuthorRepo autorRepository) {
            this.authorRepository = autorRepository;
        }

        @Override
        public List<Author> getAllAutors() {
            return authorRepository.findAll();
        }

        @Override
        public Optional<Author> getAutorById(Long id) {
            return authorRepository.findById(id);
        }

        @Override
        public Author saveAutor(Author autor) {
            return  authorRepository.save(autor);
        }

        @Override
        public Author updateAutor(Long id, Author autor) {
            Optional<Author> existingAutorOptional = authorRepository.findById(id);

            Author existingAutor = existingAutorOptional.get();
            existingAutor.setName(autor.getName()); // Mettez à jour d'autres champs si nécessaire
            return authorRepository.save(existingAutor);
        }


        @Override
        public void deleteAutor(Long id) {
            authorRepository.deleteById(id);
        }

    }
