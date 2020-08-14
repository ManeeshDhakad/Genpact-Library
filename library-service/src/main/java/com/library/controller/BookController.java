package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.service.BookService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("lib/{libId}/allBooks")
	public List<Book> getAllBooks(@PathVariable("libId") int libId) {
		 return bookService.getAllBooks(libId);
	}
	
	@PostMapping("lib/{libId}/createBook")
	public Book createBook(@PathVariable("libId") int libId, @RequestBody Book b) {
		 return bookService.createBook(libId, b);
	}
	
	@PostMapping("lib/{libId}/updateBook")
	public Book updateBookDetails(@PathVariable("libId") int libId, @RequestBody Book b) {
		 return bookService.updateBook(libId, b);
	}
	
	@DeleteMapping("lib/{libId}/removeBook/{bookId}")
	public void reomoveBook(@PathVariable("libId") int libId, @PathVariable("bookId") int bookId) {
		bookService.removeBook(libId, bookId);
	}
}

