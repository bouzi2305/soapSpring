package com.upf.exam.soap.soapspring.repository;


import com.upf.exam.soap.soapspring.entite.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Long> {
}
