package com.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.application.model.Author;
import com.application.model.Book;
import com.application.service.AuthorService;

@ExtendWith(MockitoExtension.class)
class TestAuthor {
	@InjectMocks
	AuthorService authorservice;
	
	@Mock
	com.application.rerpository.AuthorRepository authorRepository;
	@Mock
	com.application.rerpository.AuthorListRepository repository;
	@Test
	void testSave() {
		Book books = new Book();
		books.setId(1);
		books.setTitle("Do or Die");
		books.setAuthor("bolt");
		books.setCategory("friction");
		books.setPrice(130);
		books.setPublisher("PBP");
		books.setDate("1996-04-13");
		when(authorRepository.save(books)).thenReturn(books);//mock
		authorservice.save(books);
		assertEquals(1,	books.getId());
	}
	
    @Test
    public void testGetBooks() throws Exception {
        List<Book> book = new ArrayList<>();
        Book books = new Book();
        books.setId(1);
        books.setTitle("Rich Dad and Poor Dad");
        books.setAuthor("grenny");
		books.setCategory("pshycology");
		books.setPrice(239);
		books.setPublisher("CC");
		books.setDate("1880-12-11");
        book.add(books);
        when(authorRepository.findAll()).thenReturn(book);
        Iterable<Book> getbooks = authorservice.getBooks();
        assertEquals(book, getbooks);
    }
    
    @Test
    public void testGetBookById()  throws Exception{
        Optional<Book> books = Optional.of(new Book());
        Mockito.when(authorRepository.findById(1)).thenReturn(books);
        Optional<Book> bookbyid = authorservice.findBookById(1);
        assertEquals(books,bookbyid);
    }
    
    @Test
    public void testGetAuthors() throws Exception{
    	List<Author> author = new ArrayList<>();
    	Author authors = new Author();
    	authors.setId(1);
    	authors.setAge(30);
    	authors.setEmail("jj@outlook.com");
    	authors.setName("Jenni");
    	author.add(authors);
    	when(repository.findAll()).thenReturn(author);
        Iterable<Author> getauthors = authorservice.getAuthors();
        assertEquals(author, getauthors);
    }  
    
    @Test
	void testSaveAuthor() {
    	Author authors = new Author();
    	authors.setId(1);
    	authors.setAge(30);
    	authors.setEmail("jj@outlook.com");
    	authors.setName("Jenni");
		when(repository.save(authors)).thenReturn(authors);//mock
		authorservice.saveAuthor(authors);
		assertEquals(1,	authors.getId());
	}
}