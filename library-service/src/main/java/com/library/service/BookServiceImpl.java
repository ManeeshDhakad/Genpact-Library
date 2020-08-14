package com.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.entity.Library;
import com.library.repo.BookRepository;
import com.library.repo.LibraryRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	LibraryRepository libRepo;
	
	Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);
	
	@Override
	public List<Book> getAllBooks(int libId) {
		List<Book> books = new ArrayList<Book>();
		try {
			books = (List<Book>) bookRepo.findAll();
			books = books.stream().filter(book -> book.getLib().getId() == libId).collect(Collectors.toList());
			
		} catch(Exception ex) {
			logger.error(ex.getMessage());
		}
		return books;
	}
	
	@Override
	public Book createBook(int libId, Book book) {
		Book createBook = new Book();
		try {
			Library lib = libRepo.findById(libId).get();

			if(lib != null) {
				book.setLib(lib);
				createBook =  bookRepo.save(book);
			}
				
		} catch(Exception ex) {
			logger.error(ex.getMessage());
		}
		return createBook;
		
	}

	@Override
	public Book updateBook(int libId, Book b) {
		Book updatedBook = new Book();
		try {
			if(libRepo.existsById(b.getLib().getId()))
				updatedBook =  bookRepo.save(b);
		} catch(Exception ex) {
			logger.error(ex.getMessage());
		}
		return updatedBook;
		
	}

	@Override
	public Book removeBook(int libId, int bookId) {
		Book deletedBook = new Book();
		try { 
			deletedBook = bookRepo.findById(bookId).get();
			if(deletedBook != null)
				bookRepo.deleteById(bookId);
		} catch(Exception ex) {
			logger.error(ex.getMessage());
		}
		return deletedBook;
	}
}
