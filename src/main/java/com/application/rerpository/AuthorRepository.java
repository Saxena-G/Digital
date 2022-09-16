package com.application.rerpository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Book;

@Repository
public interface AuthorRepository extends JpaRepository<Book, Integer> {

	
 
}