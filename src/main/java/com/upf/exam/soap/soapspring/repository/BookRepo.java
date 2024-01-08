package com.upf.exam.soap.soapspring.repository;

import com.upf.exam.soap.soapspring.entite.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
