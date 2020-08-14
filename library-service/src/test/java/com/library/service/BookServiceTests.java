package com.library.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.library.entity.Book;
import com.library.entity.Library;
import com.library.repo.BookRepository;
import com.library.repo.LibraryRepository;

@SpringBootTest
class BookServiceTests {
	
	@InjectMocks
	BookServiceImpl bookService;


	@Mock
	private BookRepository bookRepo;

	@Mock
	private LibraryRepository libRepo;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void createBookTest() {	
		Library lib = new Library();
		lib.setId(1);
		lib.setName("Lib1");
		lib.setDescription("Lib 1 Desc");
		
		Book book = new Book();
		book.setId(1);
		book.setAuthor("Maneesh");
		book.setName("Book1");
		book.setDescription("Book 1 Desc");
		book.setLib(lib);
		
		Optional<Library> oLib = Optional.of(lib);

		when(libRepo.findById(any(Integer.class))).thenReturn(oLib);
		when(bookRepo.save(any(Book.class))).thenReturn(book);

		assertEquals(book.getName(), bookService.createBook(1, book).getName());
	}

	@Test
	void getAllBookTest() {	
		
		Library lib = new Library();
		lib.setId(1);
		lib.setName("Lib1");
		lib.setDescription("Lib 1 Desc");
		
		Book book = new Book();
		book.setId(1);
		book.setName("Book1");
		book.setDescription("Book 1 Desc");
		book.setLib(lib);
		List<Book> books = new ArrayList<>();
		books.add(book);

		when(bookRepo.findAll()).thenReturn(books);
		assertEquals(1, bookService.getAllBooks(1).size());
	}

}
