package com.blackcode.springbootcurdsimple.repository;

import com.blackcode.springbootcurdsimple.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
