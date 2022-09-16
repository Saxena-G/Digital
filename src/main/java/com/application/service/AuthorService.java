package com.application.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Author;
import com.application.model.Book;

@Service
public class AuthorService {
	
	@Autowired
	com.application.rerpository.AuthorRepository authorRepository;
	
	@Autowired
	com.application.rerpository.AuthorListRepository repository;
	
	
	public Iterable<Book> getBooks(){
		return authorRepository.findAll();
	}
	
	public Book save(@Valid Book books) {
		 if (books.getTitle().equals("Rich and Poor"))
			throw new IllegalArgumentException("message");
		else 
			authorRepository.save(books);
		return books; 
	}

	public Optional<Book> findBookById(Integer id) {
		return authorRepository.findById(id);
	}
	
	public Iterable<Author> getAuthors(){
		return repository.findAll();
	}

	public Author saveAuthor(@Valid Author authors) {
		return repository.save(authors);
	} 
}