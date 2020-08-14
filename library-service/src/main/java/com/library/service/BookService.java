package com.library.service;

import java.util.List;

import com.library.entity.Book;

public interface BookService {
	List<Book> getAllBooks(int libId);
	Book createBook(int libId, Book b);
	Book updateBook(int libId, Book b);
	Book removeBook(int libId, int id);
}
