package com.application.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Author;
import com.application.model.Book;
import com.application.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/digitalbook")
public class AuthorController extends BaseController {
	
	@Autowired 
	AuthorService authorservice;

	
	@GetMapping
	public
	Iterable<Book> getBooks() {
		return authorservice.getBooks();
	}
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Integer id){
        return authorservice.findBookById(id);
    }
     
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	 public Integer saveBook(@Valid @RequestBody Book books) {
		authorservice.save(books);
		return books.getId();
	}
	
	@GetMapping("/author")
	public
	Iterable<Author> getAuthors() {
		return authorservice.getAuthors();
	} 
	
	@PostMapping("/author")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Integer saveAuthor(@Valid @RequestBody Author author) {
		authorservice.saveAuthor(author);
		return author.getId();
	}
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
	    return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
}
